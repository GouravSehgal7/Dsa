package parkinglotSystem;

/**
 * INTENT: the smallest physical unit of the lot.
 *         A spot owns exactly one piece of state: who is occupying it (null = free).
 *         It does not search, it does not price — it only answers size/freeness questions.
 */
public class ParkingSpot {
    private final String spotId;
    private final int floorNumber;
    private final int capacity;
    private Vehical occupant;

    public ParkingSpot(String spotId, int floorNumber, int capacity) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.occupant = null;
    }

    /**
     * INTENT: decide if this spot may be given to the arriving vehicle.
     * Rule: spot must be free AND capacity must be at least the vehicle requirement.
     * @param type category of the arriving vehicle
     * @return true if the vehicle fits and the spot is unused
     */
    public boolean canFit(VehicleType type) {
        return occupant == null && type.fits(capacity);
    }

    /**
     * INTENT: reserve this spot for a vehicle.
     * The free-check is repeated inside the synchronized block so two racing threads
     * cannot both succeed on the same spot.
     * @return true when reservation succeeded, false if someone else took it
     */
    public synchronized boolean occupy(Vehical vehicle) {
        if (!canFit(vehicle.getType())) {
            return false;
        }
        this.occupant = vehicle;
        return true;
    }

    /** INTENT: clear the occupant so the same spot can be handed to the next vehicle. */
    public synchronized void vacate() {
        this.occupant = null;
    }

    /** INTENT: report whether the spot is currently empty. */
    public boolean isFree() {
        return occupant == null;
    }

    public String getSpotId() {
        return spotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public Vehical getOccupant() {
        return occupant;
    }

    @Override
    public String toString() {
        return spotId + "(floor=" + floorNumber + ", capacity=" + capacity + ")";
    }
}
