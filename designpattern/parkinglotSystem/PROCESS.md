# How to solve an LLD problem — Parking Lot, from first principles

This document is a **repeatable process** you can use on any low-level-design question,
followed by the **actual application** of that process to this parking lot problem.

The single most important habit: **do not write classes first. Write the story first.**
Classes fall out of the story almost automatically.

---

## Part 1 — The 8-step process

### Step 1: Restate the problem in one sentence
Force the vague prompt into one concrete sentence with a subject, an action and an outcome.

> "A facility with N floors and K spots accepts vehicles, reserves a spot, issues a
> ticket, and on exit charges money based on time + vehicle type."

If you cannot say it in one sentence, you have not understood the problem yet.

### Step 2: Turn vague words into explicit rules (clarifying questions)
Every noun in the prompt hides a decision. Ask until each one has an answer. Ask these
out loud in an interview — asking IS part of the evaluation.

| Vague word in prompt | Question to ask | Decision for this practice |
|---|---|---|
| "different vehicle types" | Which ones? Do they need different spot sizes? | Bike / Car / Truck; spot capacity 1 / 2 / 3 |
| "parking spot allocation" | Who decides the spot — system or driver? | System picks first fitting free spot |
| "multi-floor" | Does floor choice matter? Can rules change later? | Yes — put it behind a policy interface |
| "ticket" | What must it remember? | id, vehicle, spot, entry timestamp |
| "price based on time" | Per minute or per started hour? Rounding? | Per started hour, round up, min 1 hour |
| "payment" | Which modes? Can new modes be added? | UPI, PhonePe — behind an interface |
| "manages" | Concurrent entries? Full lot? Lost ticket? | Synchronize allocation; reject if full; lost-ticket penalty is a future extension |

Write the answers down. These answers become your **functional requirements**.

### Step 3: Extract nouns → classes, verbs → methods
Underline nouns and verbs in your one sentence.

- **Nouns (things that hold data):** `Vehicle`, `VehicleType`, `ParkingSpot`, `Floor`,
  `ParkingLot`, `Ticket`, `FeeStrategy`, `PaymentStrategy`, `Receipt`, `TicketRepository`.
- **Verbs (behaviour):** `enter/park`, `allocate`, `find free spot`, `issue ticket`,
  `leave/exit`, `calculate fee`, `pay`, `release spot`.

Rule of thumb: a noun becomes a class only if it has **state worth remembering**.
`getprice()` alone is not a class — it is behaviour, so it belongs on a strategy object.

### Step 4: Walk one end-to-end "movie" (the happy path)
Before designing structure, narrate one vehicle going in and coming out. Every step of
the movie becomes one method call.

**Entry movie**
1. Car arrives at gate → `ParkingLot.parkVehical(car)`
2. Policy picks a floor → `policy.selectFloor(floors, CAR)`
3. Floor finds a fitting spot → `floor.findFreeSpot(CAR)`
4. Spot is reserved → `spot.occupy(car)`
5. Ticket is created and stored → `new Ticket(...)`, `repo.save(ticket)`
6. Ticket handed to driver.

**Exit movie**
1. Driver shows ticket id → `ParkingLot.exitVehical(id, upiPayment)`
2. Ticket is fetched → `repo.findById(id)`
3. Fee is computed → `feeStrategy.calculateFee(ticket, now)`
4. Payment is charged → `payment.pay(amount, id)` → `Receipt`
5. Spot is freed → `allocator.release(spot)`
6. Ticket is closed → `repo.remove(id)`

If your movie has a gap, your design has a gap. This step catches more bugs than any diagram.

### Step 5: Assign ownership (encapsulation / Single Responsibility)
For each class ask: **"what is the one thing this class is the boss of?"**

| Class | It is the boss of | It is NOT responsible for |
|---|---|---|
| `ParkingLot` | orchestrating the use cases (facade) | knowing how a fee is computed |
| `Floor` | its own list of spots | which floor should be chosen |
| `ParkingSpot` | whether it is free and who occupies it | finding itself on another floor |
| `SpotAllocator` | atomic reserve/release | pricing, payment |
| `Ticket` | entry time + references | deciding its own price (delegates) |
| `TicketRepository` | storing/looking up tickets | any business rule |

A useful test: if you can describe a class only by listing "and it also...", split it.

### Step 6: Find what varies → put it behind an interface (the pattern step)
Patterns are not decoration; each one removes a specific future change.

| Thing that varies | Interface (Strategy seam) | Concrete implementations | Why |
|---|---|---|---|
| How a floor is chosen | `FloorselectionPolicy` | `LowestFloorFirstPolicy`, `MostSpacesFirstPolicy` | Swap without touching `ParkingLot` |
| How fee is computed | `FeeStrategy` | `HourlyFeeStrategy` | Add flat-rate / weekend pricing later |
| How money is collected | `PaymentStrategy` | `UpiPayment`, `PhonePePayment` | Add cards/wallets later |
| Where tickets are stored | `TicketRepository` | `InMemoryTicketRepository` | Swap to DB later |
| Which vehicle arrived | `Vehical` | `Car`, `Bike`, `Truck` | New vehicle types need no core changes |

This is the **Open/Closed Principle** in practice: add a new file, not an `if/else`.
Note the trap in your starting `Vehical.java`: nested classes make adding a vehicle
require editing that file. Separate top-level classes are easier to extend.

### Step 7: Add the non-functional reality
Now, and only now, think about robustness:

- **Concurrency:** two cars racing for the last spot → `SpotAllocator.allocate()` is
  `synchronized`, and `ParkingSpot.occupy()` re-checks freeness before setting occupant.
- **Full lot:** policy returns `null` → gate returns `null` ticket (reject entry).
- **Invalid ticket:** repository returns `null` → no payment, no crash.
- **Clock:** use `Instant` from one source; fee uses `Duration.between`.
- **Money:** `double` is fine for practice; real code uses `BigDecimal`.
- **Audit:** every exit produces a `PaymentReceipt` with an id and timestamp.
- **Singleton:** one `ParkingLot` instance for the whole facility (matches your
  `singalton` folder practice).

### Step 8: Write declarations with intent, then fill bodies
Write the **signature + one-line INTENT comment** for every method first (that is what
you were asked for, and it is also how you should think). Only after all signatures read
like a coherent story do you fill in the bodies. In this repo each method has an
`INTENT:` comment stating what the function needs to do.

---

## Part 2 — Applied output for this problem

### Class / file map

```
VehicleType.java              enum: BIKE/CAR/TRUCK -> required spot size + hourly rate
Vehical.java                  interface: getType(), getLicensePlate()      [your rewritten file]
Car.java / Bike.java / Truck.java    concrete vehicles
ParkingSpot.java              capacity, occupant; canFit/occupy/vacate
Floor.java                    floorNumber + List<ParkingSpot>; findFreeSpot
FloorselectionPolicy.java     interface: selectFloor(...)                  [your rewritten file]
LowestFloorFirstPolicy.java   concrete allocation strategy
MostSpacesFirstPolicy.java    concrete allocation strategy
SpotAllocator.java            synchronized allocate(); uses policy
Ticket.java                   id, vehicle, spot, entryTime; calculateFee()
FeeStrategy.java              interface: calculateFee(ticket, exitTime)
HourlyFeeStrategy.java        round up to started hours
PaymentStrategy.java          interface: pay(amount, ticketId)
UpiPayment.java / PhonePePayment.java
PaymentReceipt.java           id, amount, mode, paidAt
TicketRepository.java         interface: save/findById/remove
InMemoryTicketRepository.java HashMap implementation
ParkingLot.java               singleton facade: parkVehical(), exitVehical()
ParkingLotDemo.java           main() walking both movies
parkinglot-system.drawio.svg  class diagram (open in draw.io)
```

### Dependency shape (who calls whom)

```
ParkingLot
 ├─> SpotAllocator ──> FloorselectionPolicy ──< LowestFloorFirst / MostSpacesFirst
 │                 └─> Floor ──* ParkingSpot ──o Vehical ──> VehicleType
 ├─> TicketRepository <── InMemoryTicketRepository
 ├─> Ticket ──> FeeStrategy <── HourlyFeeStrategy
 └─> PaymentStrategy <── UpiPayment / PhonePePayment ──> PaymentReceipt
```

### Design decisions worth saying out loud in an interview
1. I modelled **spot size as a number** (1/2/3) so a car can park in a large spot —
   avoids a pile of `if (type == TRUCK)` checks.
2. I kept **allocation and pricing separate**: the allocator never knows about money.
3. `Ticket` stores a **reference to the spot**, so exit can free the exact spot without
   a search.
4. The **policy chooses a floor, the allocator reserves the spot** — two small steps
   instead of one fat method, so each can be tested/changed alone.
5. I used a `double` for money only to keep the practice code short; production code
   should use `BigDecimal` and a currency.

### Reusable checklist for your next LLD problem
- [ ] One-sentence restatement
- [ ] 5–8 clarifying questions with decided answers
- [ ] Noun/verb list
- [ ] Entry + exit movie (every step = one method)
- [ ] One "boss" sentence per class
- [ ] A table of things that vary → interfaces
- [ ] Concurrency / full / invalid-input behaviour
- [ ] Signatures with INTENT comments before bodies
- [ ] Diagram + a runnable `main()` to prove it works
