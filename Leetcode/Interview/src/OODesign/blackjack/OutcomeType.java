package OODesign.blackjack;

/**
 * Created by shoulongli on 5/18/16.
 */
public enum OutcomeType {
    None(0),
    Won(1),
    Lost(2),
    Push(3),
    Bust(4),
    Blackjack(5);
    private int value;
    OutcomeType(int value) {
        this.value = value;
    }
}
