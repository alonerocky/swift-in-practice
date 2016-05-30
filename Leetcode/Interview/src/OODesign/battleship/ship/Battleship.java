package OODesign.battleship.ship;

import OODesign.battleship.Ship;
import OODesign.battleship.ShipType;

/**
 * Created by shoulongli on 5/19/16.
 */
public class Battleship extends Ship {
    private static final int SIZE = 4;
    public Battleship() {
        super(ShipType.Battleship);
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isSunk() {
        return SIZE == hits;
    }
}
