public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            List<Interval> result = new ArrayList<Interval>();
            result.add(newInterval);
            return result;
        }
        int i = 0; 
        while (i < intervals.size()) {
            Interval current = intervals.get(i);
            if (hasOverlap(current, newInterval) ){
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);
                intervals.remove(i); //i+1, will become the i, and continue
            } else if (newInterval.end < current.start) {
                intervals.add(i, newInterval);
                return intervals;
            } else { //newInterval.start > current.end
                i++;
            }
        }
        //i == intervals.size();
        intervals.add(newInterval);
        return intervals;
    }
    
    private boolean hasOverlap(Interval i1, Interval i2) {
        return !(i1.end < i2.start || i1.start > i2.end);
    }
