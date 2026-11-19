package parkinglotSystem;

import java.util.List;

/** INTENT: allocation rule that spreads cars out by choosing the emptiest floor. */
public class MostSpacesFirstPolicy implements FloorselectionPolicy {

    /**
     * INTENT: compare all floors by their count of fitting free spots and return the winner.
     * Return null when every floor has zero fitting free spots.
     */
    @Override
    public Floor selectFloor(List<Floor> floors, VehicleType type) {
        Floor best = null;
        int bestCount = 0;
        for (Floor floor : floors) {
            int count = floor.freeSpotCount(type);
            if (count > bestCount) {
                best = floor;
                bestCount = count;
            }
        }
        return best;
    }
}
