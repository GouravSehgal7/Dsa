package parkinglotSystem;

import java.util.List;

/** INTENT: allocation rule that prefers the lowest-numbered floor (closest to the exit). */
public class LowestFloorFirstPolicy implements FloorselectionPolicy {

    /**
     * INTENT: scan floors from 0 upward and return the first one with a fitting free spot.
     * Return null when no floor can host the vehicle.
     */
    @Override
    public Floor selectFloor(List<Floor> floors, VehicleType type) {
        for (Floor floor : floors) {
            if (floor.freeSpotCount(type) > 0) {
                return floor;
            }
        }
        return null;
    }
}
