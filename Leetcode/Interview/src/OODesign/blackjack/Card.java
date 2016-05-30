package OODesign.blackjack;

/**
 * Created by shoulongli on 5/15/16.
 */
public abstract class Card {
    protected CardType type;
    protected CardSuit suit;

    public Card(CardType type, CardSuit suit) {
        this.type = type;
        this.suit = suit;
    }

    public abstract int getValue();
}
