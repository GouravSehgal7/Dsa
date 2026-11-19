package parkinglotSystem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * INTENT: the front door of the whole facility (facade + singleton).
 *         It only orchestrates other objects; it does not implement pricing,
 *         allocation, storage or payment itself.
 */
public class ParkingLot {
    private static ParkingLot instance;

    private final List<Floor> floors = new ArrayList<>();
    private final SpotAllocator allocator;
    private final FeeStrategy feeStrategy;
    private final TicketRepository ticketRepository;

    private ParkingLot(FloorselectionPolicy policy, FeeStrategy feeStrategy,
                       TicketRepository ticketRepository) {
        this.allocator = new SpotAllocator(floors, policy);
        this.feeStrategy = feeStrategy;
        this.ticketRepository = ticketRepository;
    }

    /**
     * INTENT: return the single ParkingLot object for the facility.
     * First call supplies the strategies (dependencies are injected, not created here).
     */
    public static synchronized ParkingLot getInstance(FloorselectionPolicy policy,
                                                      FeeStrategy feeStrategy,
                                                      TicketRepository ticketRepository) {
        if (instance == null) {
            instance = new ParkingLot(policy, feeStrategy, ticketRepository);
        }
        return instance;
    }

    /** INTENT: setup step — add a floor before the facility opens. */
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    /**
     * INTENT: ENTRY use case — reserve a spot, issue a ticket, remember the ticket.
     * @return the ticket to hand to the driver, or null when the lot is full
     */
    public Ticket parkVehical(Vehical vehicle) {
        ParkingSpot spot = allocator.allocate(vehicle);
        if (spot == null) {
            return null;
        }
        Ticket ticket = new Ticket(vehicle, spot);
        ticketRepository.save(ticket);
        return ticket;
    }

    /**
     * INTENT: EXIT use case — price the stay, charge it, free the spot, close the ticket.
     * @param ticketId the id printed on the ticket
     * @param payment  gateway chosen by the driver at the exit gate
     * @return receipt on success, null when the ticket is unknown or already used
     */
    public PaymentReceipt exitVehical(String ticketId, PaymentStrategy payment) {
        Ticket ticket = ticketRepository.findById(ticketId);
        if (ticket == null) {
            return null;
        }
        double fee = ticket.calculateFee(feeStrategy, Instant.now());
        PaymentReceipt receipt = payment.pay(fee, ticketId);
        allocator.release(ticket.getSpot());
        ticketRepository.remove(ticketId);
        return receipt;
    }
}
