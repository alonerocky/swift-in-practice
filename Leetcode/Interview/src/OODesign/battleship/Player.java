package OODesign.battleship;

import OODesign.battleship.ship.*;

public class Player {

    //ships
    //battelfield
    //trackinggrid
    private String name;
    private Ship[] ships;

    public Player(String name) {
        this.name = name;
        initialize();
    }

    public void initialize() {
        //set up the ships
        ships[0] =  new AircraftCarrier();
        ships[1] = new Battleship();
        ships[2] = new Submarrine();
        ships[3] = new Destroyer();
        ships[4] = new Patrol();
    }

    public String getName() {
        return name;
    }

    public void playShip() {
        //TODO
    }

    public void takeShot(int x, int y) {
        //TODO
    }
}
