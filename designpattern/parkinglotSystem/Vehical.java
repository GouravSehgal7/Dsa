package parkinglotSystem;

/**
 * INTENT: the contract every vehicle must satisfy.
 *         This replaces the empty nested IVehicle you started with.
 *         Keeping it as an interface means a new vehicle is a new file,
 *         not a change to the parking lot logic.
 */
public interface Vehical {

    /** INTENT: tell the system the category, which drives spot size and price. */
    VehicleType getType();

    /** INTENT: provide a unique physical id used on the ticket and receipt for audit. */
    String getLicensePlate();
}
