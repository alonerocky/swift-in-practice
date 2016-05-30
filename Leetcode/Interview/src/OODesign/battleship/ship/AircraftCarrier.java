package OODesign.battleship.ship;

import OODesign.battleship.Ship;
import OODesign.battleship.ShipType;

/**
 * Created by shoulongli on 5/19/16.
 */
public class AircraftCarrier extends Ship {
    private int SIZE = 5;
    public AircraftCarrier() {
        super(ShipType.AircraftCarrier);
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isSunk() {
        return SIZE == hits;
    }
}
