import java.util.Queue;
import java.util.LinkedList;
import java.util.EmptyStackException;
class MyStack {
    // Push element x onto stack.
    //new element always come to the queue head pointed to
    Queue<Integer> head = new LinkedList<Integer>();
    Queue<Integer> tail = new LinkedList<Integer>();
    public void push(int x) {
        head.offer(x);
        while (!tail.isEmpty()) {
            head.offer(tail.poll());
        }
        //swap head with tail
        Queue<Integer> temp = head;
        head = tail;
        tail = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        tail.poll();
    }

    // Get the top element.
    public int top() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return tail.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return tail.isEmpty();
    }
}