package parkinglotSystem;

/** INTENT: a heavy vehicle; needs the largest spot and pays the highest rate. */
public class Truck implements Vehical {
    private final String licensePlate;

    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /** INTENT: return TRUCK so only large spots are offered to it. */
    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

    /** INTENT: return the truck's unique registration number. */
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Truck(" + licensePlate + ")";
    }
}
