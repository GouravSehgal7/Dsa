package parkinglotSystem;

import java.time.Instant;
import java.util.UUID;

/** INTENT: immutable proof that a payment happened; written to the audit trail. */
public class PaymentReceipt {
    private final String transactionId;
    private final String ticketId;
    private final double amount;
    private final String mode;
    private final Instant paidAt;

    public PaymentReceipt(String ticketId, double amount, String mode) {
        this(UUID.randomUUID().toString(), ticketId, amount, mode, Instant.now());
    }

    public PaymentReceipt(String transactionId, String ticketId, double amount,
                          String mode, Instant paidAt) {
        this.transactionId = transactionId;
        this.ticketId = ticketId;
        this.amount = amount;
        this.mode = mode;
        this.paidAt = paidAt;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMode() {
        return mode;
    }

    public Instant getPaidAt() {
        return paidAt;
    }

    @Override
    public String toString() {
        return "Receipt[" + transactionId + " | " + mode + " | " + amount
                + " | ticket=" + ticketId + "]";
    }
}
