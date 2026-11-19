package parkinglotSystem;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

/**
 * INTENT: the contract between the garage and the driver.
 *         It remembers facts only; pricing is delegated to a FeeStrategy.
 */
public class Ticket {
    private final String ticketId;
    private final Vehical vehicle;
    private final ParkingSpot spot;
    private final Instant entryTime;

    /** INTENT: create a fresh ticket at "now" for a vehicle that just got a spot. */
    public Ticket(Vehical vehicle, ParkingSpot spot) {
        this(UUID.randomUUID().toString(), vehicle, spot, Instant.now());
    }

    /** INTENT: full constructor, also useful for tests with a fixed entry time. */
    public Ticket(String ticketId, Vehical vehicle, ParkingSpot spot, Instant entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
    }

    /** INTENT: compute how long the vehicle stayed, in whole minutes. */
    public long getDurationMinutes(Instant exitTime) {
        return Duration.between(entryTime, exitTime).toMinutes();
    }

    /** INTENT: ask the injected strategy for the amount due (keeps pricing outside Ticket). */
    public double calculateFee(FeeStrategy strategy, Instant exitTime) {
        return strategy.calculateFee(this, exitTime);
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehical getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Instant getEntryTime() {
        return entryTime;
    }
}
