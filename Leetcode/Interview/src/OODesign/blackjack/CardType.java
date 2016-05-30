package OODesign.blackjack;

import OODesign.parkinglot.Car;

/**
 * Created by shoulongli on 5/15/16.
 */
public enum CardType {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int type;

    CardType(int type) {
        this.type = type;
    }
}
