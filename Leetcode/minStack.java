import java.util.Stack;
import java.util.EmptyStackException;
class MinStack {
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() throws EmptyStackException {
        if (stack.empty()) {
            throw new EmptyStackException();
        }
        int top = stack.pop();
        if (!minStack.empty() && minStack.peek() == top) {
            minStack.pop();
        }
    }

    public int top() throws EmptyStackException {
        if (stack.empty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    public int getMin() throws EmptyStackException {
        if (minStack.empty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }
}
