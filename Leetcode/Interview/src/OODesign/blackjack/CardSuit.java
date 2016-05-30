package OODesign.blackjack;

/**
 * Created by shoulongli on 5/15/16.
 */
public enum CardSuit {

    HEATS(0),
    SPADES(1),
    DIAMONDS(2),
    CLUBS(3);

    private int suit;

    CardSuit(int suit) {
        this.suit = suit;
    }
}
