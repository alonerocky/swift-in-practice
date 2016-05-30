/**
 * Created by shoulongli on 3/11/16.
 */
public class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode p = head;
        RandomListNode deepCopy = null;
        while (p != null) {
            RandomListNode node = p;
            p = p.next;
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = p;
            node.next = newNode;
            if (deepCopy == null) {
                deepCopy = newNode;
            }
        }

        //link the random pointer
        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        //get the new list out
        p = head;
        while (p != null ) {
            RandomListNode q = p.next;
            RandomListNode temp = q.next;
            q.next = q.next == null ? null : q.next.next;
            p.next = temp;
            p = p.next;
        }

        return deepCopy;
    }
}
