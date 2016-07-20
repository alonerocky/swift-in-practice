class MedianFinder {
    private PriorityQueue<Integer> maxHeap; //for the first half
    private PriorityQueue<Integer> minHeap; //for the second half
    public MedianFinder() {
         minHeap = new PriorityQueue<Integer>(16);
         maxHeap = new PriorityQueue<Integer>(16, Collections.reverseOrder());
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        // 0=< m - n <= 1 , m is the size of first half
        //n is the size of the second half
        int m = maxHeap.size();
        int n = minHeap.size();
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
        } else if (minHeap.isEmpty()) {
            if (num <= maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        } else {
            int max = maxHeap.peek();
            int min = minHeap.peek(); //max <= min
            if (num <= min) {
                maxHeap.offer(num);
                if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.offer(maxHeap.poll());
                }
            } else  {
                minHeap.offer(num);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        // 0=< m - n <= 1
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
};
