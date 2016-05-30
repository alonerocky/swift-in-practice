package OODesign.battleship;

public abstract class Ship {
    private ShipType type;
    protected int hits;

    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getType() {
        return this.type;
    }

    public abstract int getSize();
    public abstract boolean isSunk();

}
