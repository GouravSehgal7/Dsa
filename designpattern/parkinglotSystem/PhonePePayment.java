package parkinglotSystem;

/** INTENT: concrete gateway #2 — collects money through PhonePe. */
public class PhonePePayment implements PaymentStrategy {

    /** INTENT: simulate the PhonePe call, then hand back a receipt tagged "PHONEPE". */
    @Override
    public PaymentReceipt pay(double amount, String ticketId) {
        return new PaymentReceipt(ticketId, amount, "PHONEPE");
    }
}
