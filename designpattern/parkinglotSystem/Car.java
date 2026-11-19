package parkinglotSystem;

/** INTENT: a four-wheeler; needs a medium-or-larger spot. */
public class Car implements Vehical {
    private final String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /** INTENT: return CAR so spot sizing and hourly rate are looked up correctly. */
    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    /** INTENT: return the car's unique registration number. */
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Car(" + licensePlate + ")";
    }
}
