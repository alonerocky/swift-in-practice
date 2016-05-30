import java.util.Stack;
import java.util.NoSuchElementException;
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> tailStack = new Stack<Integer>();
    Stack<Integer> headStack = new Stack<Integer>();
    public void push(int x) {
        tailStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        if (headStack.empty()) {
            moveTailToHead();
        }
        headStack.pop();

    }

    // Get the front element.
    public int peek() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        if (headStack.empty()) {
            moveTailToHead();
        }
        return headStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return tailStack.empty() && headStack.empty();
    }

    private void moveTailToHead() {
        while (!tailStack.empty()) {
            headStack.push(tailStack.pop());
        }
    }
}
