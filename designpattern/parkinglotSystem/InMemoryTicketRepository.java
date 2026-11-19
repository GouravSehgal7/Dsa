package parkinglotSystem;

import java.util.HashMap;
import java.util.Map;

/** INTENT: simple in-memory ticket store using a map keyed by ticket id. */
public class InMemoryTicketRepository implements TicketRepository {
    private final Map<String, Ticket> tickets = new HashMap<>();

    /** INTENT: put the ticket into the map under its own id. */
    @Override
    public void save(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }

    /** INTENT: return the stored ticket, or null when the id is unknown. */
    @Override
    public Ticket findById(String ticketId) {
        return tickets.get(ticketId);
    }

    /** INTENT: delete the ticket so a second exit attempt fails safely. */
    @Override
    public void remove(String ticketId) {
        tickets.remove(ticketId);
    }
}
