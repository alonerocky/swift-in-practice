public class MovingAverage {
    private Deque<Integer> queue ;
    private int size;
    private double total;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<Integer>(size);
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() < size) {
            queue.addLast(val);
            total += val;
        } else {
            int front = queue.pollFirst();
            queue.addLast(val);
            total = total + val - front;
        }
        return total/queue.size();
    }
}
