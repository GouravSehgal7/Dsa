package parkinglotSystem;

import java.util.List;

/**
 * INTENT: Strategy seam for floor choice.
 *         ParkingLot/SpotAllocator depend on this interface, not on a concrete rule,
 *         so a new allocation rule means adding a class, not editing the core.
 */
public interface FloorselectionPolicy {

    /**
     * INTENT: pick the floor where the arriving vehicle should be sent.
     * @param floors all floors of the facility
     * @param type   category of the arriving vehicle
     * @return a floor that has a fitting free spot, or null if the lot is full
     */
    Floor selectFloor(List<Floor> floors, VehicleType type);
}
