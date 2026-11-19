package parkinglotSystem;

/** INTENT: concrete gateway #1 — collects money through a UPI id. */
public class UpiPayment implements PaymentStrategy {

    /** INTENT: simulate the UPI call, then hand back a receipt tagged "UPI". */
    @Override
    public PaymentReceipt pay(double amount, String ticketId) {
        return new PaymentReceipt(ticketId, amount, "UPI");
    }
}
