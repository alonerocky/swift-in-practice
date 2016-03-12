public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                return -1;
            } else if (o1.start > o2.start) {
                return 1;
            } else {
                if (o1.end == o2.end) {
                    return 0;
                } else if (o1.end < o2.end) {
                    return -1;
                } else {
                    return 1;
                }
            }
            }
        };
          
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        } 
        
        Collections.sort(intervals, comparator);
        
        int i = 1;
        while (i < intervals.size()) {
            Interval previous = intervals.get(i-1);
            Interval current = intervals.get(i);
            if (!hasOverlap(previous, current)) {
                i++;
            } else {
                previous.start = Math.min(previous.start, current.end);
                previous.end = Math.max(previous.end, current.end);
                intervals.remove(i);
            }
        }
        return intervals;
        
    }
    
    private boolean hasOverlap(Interval i1, Interval i2) {
        return !(i1.end < i2.start || i1.start > i2.end);
    }
