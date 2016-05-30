package OODesign.battleship.ship;

import OODesign.battleship.Ship;
import OODesign.battleship.ShipType;

/**
 * Created by shoulongli on 5/19/16.
 */
public class Destroyer extends Ship {

    private static final int SIZE = 3;
    public Destroyer() {
        super(ShipType.Destroyer);
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isSunk() {
        return SIZE == hits;
    }
}
