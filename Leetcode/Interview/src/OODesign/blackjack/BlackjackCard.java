package OODesign.blackjack;

/**
 * Created by shoulongli on 5/18/16.
 */
public class BlackjackCard extends Card {
    public BlackjackCard(CardType type, CardSuit suit) {
        super(type, suit);
    }
    public int getValue() {
        switch (type) {
            case ACE:
                return 11;
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default:
                return type.ordinal();
        }
    }

    public int getSoftvalue() {
        //ACE can be 1 or 11
        if (type == CardType.ACE) {
            return 1;
        }
        return getValue();
    }
}
