public class HitCounter {

    /** Initialize your data structure here. */
    //solution I
    Deque<Integer> timeDeque = new ArrayDeque<Integer>();
    
    //solution II
    public static final int SLOT = 300;
    private int[] time;
    private int[] hits;
    public HitCounter() {
        time = new int[SLOT];
        hits = new int[SLOT];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hitI(int timestamp) {
        timeDeque.addLast(timestamp);
    }
    
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (time[index] != timestamp) {
            time[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHitsI(int timestamp) {
        while(!timeDeque.isEmpty() && (timestamp - timeDeque.peekFirst()) >= 300) {
            timeDeque.pollFirst();
        }
        return timeDeque.size();
    }
    
    public int getHits(int timestamp) {
        int hitsTotal = 0;
        for(int i = 0; i < 300; i++) {
            
            if (timestamp - time[i] < 300) {
                hitsTotal += hits[i];
            }
        }
        return hitsTotal;
    }
}
