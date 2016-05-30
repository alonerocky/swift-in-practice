package OODesign.blackjack;

/**
 * Created by shoulongli on 5/15/16.
 */
public class Dealer {

    private Hand hand;
    public Dealer() {

    }

    public void reset() {
        hand = new Hand();
    }
}
