package parkinglotSystem;

import java.time.Instant;

/** INTENT: pricing rule that charges per started hour, with a minimum of one hour. */
public class HourlyFeeStrategy implements FeeStrategy {

    /**
     * INTENT: round the stay up to whole hours and multiply by the vehicle's hourly rate.
     * Example: 61 minutes -> 2 hours; 5 minutes -> 1 hour.
     */
    @Override
    public double calculateFee(Ticket ticket, Instant exitTime) {
        long minutes = ticket.getDurationMinutes(exitTime);
        long hours = Math.max(1, (minutes + 59) / 60);
        return hours * ticket.getVehicle().getType().getHourlyRate();
    }
}
