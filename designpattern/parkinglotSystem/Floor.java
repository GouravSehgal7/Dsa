package parkinglotSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * INTENT: one floor of the facility; it is the boss of its own spots.
 *         It never decides which floor is best — that is the policy's job.
 */
public class Floor {
    private final int floorNumber;
    private final List<ParkingSpot> spots = new ArrayList<>();

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    /** INTENT: register a spot during setup; the system builds floors before opening. */
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    /**
     * INTENT: find the first free spot on this floor that fits the vehicle.
     * @return a free spot, or null when this floor cannot help
     */
    public ParkingSpot findFreeSpot(VehicleType type) {
        for (ParkingSpot spot : spots) {
            if (spot.canFit(type)) {
                return spot;
            }
        }
        return null;
    }

    /** INTENT: count usable free spots here, used by policies that compare floors. */
    public int freeSpotCount(VehicleType type) {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (spot.canFit(type)) {
                count++;
            }
        }
        return count;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
