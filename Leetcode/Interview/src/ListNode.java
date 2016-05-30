import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shoulongli on 3/11/16.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    public static void main(String[] argv){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        printList(node1);
        reorderList(node1);
        printList(node1);
    }
    public static void printList(ListNode head) {
        if (head != null) {
            System.out.println();
            ListNode p = head;
            while (p != null) {
                System.out.print(p.val+" -> ");
                p = p.next;
            }

        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        ListNode tail = null;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, comparator);
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                minHeap.offer(node);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            if (result == null) {
                result = minNode;
                tail = minNode;
            } else {
                tail.next = minNode;
                tail = tail.next;
            }
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return result;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode result = null;
        ListNode tail = null;
        while (p.next != null) {
            ListNode one = p;
            ListNode two = p.next;
            p = p.next.next;
            //swap
            one.next = null;
            two.next = one;
            if (result == null) {
                result = two;
                tail = one;
            } else {
                tail.next = two;
                tail = one;
            }
        }
        return result;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tail = slow;
            slow = slow.next;
        }

        if (fast != null) {
            tail = slow;
            slow = slow.next;
        }
        //now slow  point to start of second , if total numbers is even
        tail.next = null;
        //reverse the second part
        ListNode p = slow;
        ListNode q = null;
        while (p != null) {
            ListNode one = p;
            p = p.next;
            one.next = q;
            q = one;
        }

        //q point the reversed second
        p = head;
        while (q != null) {
            ListNode one = q;
            q = q.next;

            one.next = p.next;
            p.next = one;

            p = one.next;

        }

    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode tail = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tail = slow;
            slow = slow.next;
        }

        if (fast != null) {
            tail = slow;
            slow = slow.next;
        }
        tail.next = null;
        ListNode reversed = null;
        while (slow != null) {
            ListNode one = slow;
            slow = slow.next;
            one.next = reversed;
            reversed = one;
        }

        //now reversed point to reversed second part
        //compare them
        ListNode p = head;
        ListNode q = reversed;
        //p is either equal or one more elemnt than q
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        //fist get the number of nodes
        ListNode p = head;
        ListNode tail = null;
        int num = 0;
        while(p != null) {
            num ++;
            tail = p;
            p = p.next;
        }

        k = k % num;

        //get the (n - k)th node
        p = head;
        ListNode previous = null;
        int i = 0;
        while (i < num - k) {
            previous = p;
            p = p.next;
            i++;
        }
        //previous will be the new tail, p will be new head;
        previous.next = null;
        tail.next = head;
        return p;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        //get the number of nodes;
        ListNode p = head;
        int num = 0;
        while (p != null) {
            num++;
            p = p.next;
        }

        //num is the
        //calculate which node is the

        //validate n
        if (n > num) {
            return head;
        }
        ListNode previous = null;
        //num + 1 - n  will be the index (start from 1) from the beginning
        int i = 1;
        p = head;
        while (i < num + 1 - n) {
            previous = p;
            p = p.next;
            i++;
        }
        //p now point to num + 1 - n
        if (previous == null) {
            //remove the first one;
            ListNode q = p;
            p = p.next;
            q.next = null;
            return p;
        } else {
            previous.next = p.next;
            p.next = null;
            return head;
        }
    }
}
