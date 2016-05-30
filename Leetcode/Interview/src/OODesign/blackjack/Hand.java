package OODesign.blackjack;

import java.util.ArrayList;

/**
 * Created by shoulongli on 5/15/16.
 */
public class Hand {
    //the maximal cards allowed for one hand
    public static final int MAX_CARDS = 12;
    private ArrayList<Card> cards;
    private boolean doubled;
    private int wager;
    public Hand() {
        cards = new ArrayList<>();
    }

    private void addWager(int wager) {
        this.wager += wager;
    }

    private void doubleDown() {
        doubled = true;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    //can split
    public boolean isPair() {
        return cards.size() == 2
                && cards.get(0).getValue() == cards.get(1).getValue();
    }

    public boolean is21() {
        return getValue() == 21;
    }

    public boolean isBlackjack() {
        return getValue() == 21 && cards.size() == 2;
    }

    public boolean isBusted() {
        return getValue() > 21;
    }

    public int getValue() {
        int total = 0;
        int aceCount = 0;
        for (int i =0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.type == CardType.ACE) {
                aceCount++;
            }
            total += card.getValue();
        }
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
            if (total <= 21) {
                break;
            }
        }
        return total;
    }

    public OutcomeType compareTo(Hand other, int numOfHands) {
        int total = getValue();
        int otherTotal = other.getValue();
        if (isBlackjack()) {
            if (other.isBlackjack()) {
                return OutcomeType.Push;
            } else {
                return OutcomeType.Won;
            }
        } else if (is21()) {
            if (other.isBlackjack()) {
                return OutcomeType.Lost;
            } else if (other.is21()) {
                return OutcomeType.Push;
            } else {
                return OutcomeType.Won;
            }
        } else if (isBusted()) {
            return OutcomeType.Lost;
        } else {
            if (total > otherTotal) {
                return OutcomeType.Won;
            } else if (total < otherTotal) {
                return OutcomeType.Lost;
            } else {
                return OutcomeType.Push;
            }
        }

    }
}
