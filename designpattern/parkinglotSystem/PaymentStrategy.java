package parkinglotSystem;

/**
 * INTENT: Strategy seam for payment gateways.
 *         ParkingLot only knows "pay this amount", never UPI/PhonePe details.
 */
public interface PaymentStrategy {

    /**
     * INTENT: charge the amount through a concrete gateway and return proof of payment.
     * @param amount   fee calculated by the FeeStrategy
     * @param ticketId used to correlate the payment with the stay
     * @return receipt for the transaction
     */
    PaymentReceipt pay(double amount, String ticketId);
}
