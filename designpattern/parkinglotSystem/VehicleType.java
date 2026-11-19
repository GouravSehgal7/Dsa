package parkinglotSystem;

/**
 * Enum of supported vehicles.
 * INTENT: keep the two facts that vary per vehicle type in one place:
 *         how much spot space it needs and what it costs per hour.
 */
public enum VehicleType {
    BIKE(1, 10.0),
    CAR(2, 20.0),
    TRUCK(3, 40.0);

    private final int requiredSpotSize;
    private final double hourlyRate;

    VehicleType(int requiredSpotSize, double hourlyRate) {
        this.requiredSpotSize = requiredSpotSize;
        this.hourlyRate = hourlyRate;
    }

    /** INTENT: report the minimum spot capacity this vehicle needs (1 small, 2 medium, 3 large). */
    public int getRequiredSpotSize() {
        return requiredSpotSize;
    }

    /** INTENT: report the price of one started hour for this vehicle type. */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /** INTENT: answer whether a spot of the given capacity is big enough for this vehicle. */
    public boolean fits(int spotCapacity) {
        return spotCapacity >= requiredSpotSize;
    }
}
