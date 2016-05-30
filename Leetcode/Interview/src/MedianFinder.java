import java.util.Comparator;
import java.util.PriorityQueue;
class MedianFinder {
    private PriorityQueue<Integer> maxHeap ;//store the first half
    private PriorityQueue<Integer> minHeap; //store the second half
    public MedianFinder() {
        Comparator<Integer> desc = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        };
        maxHeap = new PriorityQueue<Integer>(16, desc);
        minHeap = new PriorityQueue<Integer>(16); //default is asc
        //we need balance the both sides, make sure, their size is no more than 1
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        } else if (maxHeap.isEmpty()) {
            if (num > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else if (minHeap.isEmpty()) {
            if (num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        } else {
            //max is the end element of the first half
            //min is the start of the second half
            //max <= min
            int max = maxHeap.peek();
            int min = minHeap.peek();
            if (num <= max) {
                //need insert to left part
                if (maxHeap.size() <= minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }
            } else if (num >= min) {
                //need insert to right part
                if (minHeap.size() <= maxHeap.size()) {
                    minHeap.offer(num);
                } else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }
            } else {
                if (maxHeap.size() <= minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
            }
        }

    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}