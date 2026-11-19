package parkinglotSystem;

import java.time.Instant;

/**
 * INTENT: Strategy seam for pricing.
 *         Adding a weekend/flat-rate/subscription rule requires only a new class.
 */
public interface FeeStrategy {

    /**
     * INTENT: turn (vehicle type, duration) into the amount to charge.
     * @param ticket   holds vehicle type and entry time
     * @param exitTime supplied by the caller so fee logic never reads the clock itself
     * @return amount due
     */
    double calculateFee(Ticket ticket, Instant exitTime);
}
