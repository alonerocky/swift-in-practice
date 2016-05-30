package OODesign.battleship.ship;

import OODesign.battleship.Ship;
import OODesign.battleship.ShipType;

/**
 * Created by shoulongli on 5/19/16.
 */
public class Patrol extends Ship {
    public static final int SIZE = 2;
    public Patrol() {
        super(ShipType.Patrol);
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isSunk() {
        return SIZE == hits;
    }
}
