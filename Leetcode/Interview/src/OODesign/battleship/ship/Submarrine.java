package OODesign.battleship.ship;

import OODesign.battleship.Ship;
import OODesign.battleship.ShipType;

/**
 * Created by shoulongli on 5/19/16.
 */
public class Submarrine extends Ship {
    private static final int SIZE = 3;
    public Submarrine() {
        super(ShipType.Submarine);
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isSunk() {
        return SIZE == hits;
    }
}
