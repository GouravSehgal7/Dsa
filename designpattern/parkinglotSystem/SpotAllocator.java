package parkinglotSystem;

import java.util.List;

/**
 * INTENT: the only place allowed to reserve or release a spot.
 *         It combines the floor policy with the floor's own spot search.
 */
public class SpotAllocator {
    private final List<Floor> floors;
    private final FloorselectionPolicy policy;

    public SpotAllocator(List<Floor> floors, FloorselectionPolicy policy) {
        this.floors = floors;
        this.policy = policy;
    }

    /**
     * INTENT: reserve exactly one fitting free spot for the vehicle and return it.
     * synchronized is essential: two cars arriving together must never get the same spot.
     * @return the reserved spot, or null when the lot is full
     */
    public synchronized ParkingSpot allocate(Vehical vehicle) {
        Floor floor = policy.selectFloor(floors, vehicle.getType());
        if (floor == null) {
            return null;
        }
        ParkingSpot spot = floor.findFreeSpot(vehicle.getType());
        if (spot == null) {
            return null;
        }
        return spot.occupy(vehicle) ? spot : null;
    }

    /** INTENT: give a spot back to the pool when its ticket is closed. */
    public void release(ParkingSpot spot) {
        spot.vacate();
    }
}
