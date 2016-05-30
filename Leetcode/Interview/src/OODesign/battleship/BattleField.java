package OODesign.battleship;

public class BattleField {
    private static final int FIELD_SIZE = 10;
    private Cell[] field ;
    public BattleField() {
        field = new Cell[FIELD_SIZE];
    }

}
