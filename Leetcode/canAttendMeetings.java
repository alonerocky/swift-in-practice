public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> comparator = new Comparator<Interval>() {
          @Override
          public int compare(Interval i1, Interval i2) {
              if (i1.start == i2.start) {
                  return i1.end - i2.end;
              } else {
                  return i1.start - i2.start;
              }
          }
        };
        Arrays.sort(intervals, comparator);
        for (int i =0; i < intervals.length - 1; i++) {
            if (hasOverlap(intervals[i], intervals[i+1])) {
                return false;
            }
        }
        return true;
    }
    private boolean hasOverlap(Interval i1, Interval i2) {
        return !(i1.end <= i2.start || i1.start >= i2.end);
    }
