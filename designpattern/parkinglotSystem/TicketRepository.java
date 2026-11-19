package parkinglotSystem;

/**
 * INTENT: storage seam for active tickets.
 *         In memory for practice; a DB implementation can replace it later
 *         without changing ParkingLot.
 */
public interface TicketRepository {

    /** INTENT: store a newly issued ticket so it can be found at exit. */
    void save(Ticket ticket);

    /** INTENT: look up a ticket by the id printed on it; null means invalid/lost. */
    Ticket findById(String ticketId);

    /** INTENT: remove the ticket after payment so the same spot cannot be exited twice. */
    void remove(String ticketId);
}
