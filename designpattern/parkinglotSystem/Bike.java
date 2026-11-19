package parkinglotSystem;

/** INTENT: a two-wheeler; needs the smallest spot and pays the lowest rate. */
public class Bike implements Vehical {
    private final String licensePlate;

    public Bike(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /** INTENT: return BIKE so the allocator and fee strategy can make their decisions. */
    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }

    /** INTENT: return the bike's unique registration number. */
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Bike(" + licensePlate + ")";
    }
}
