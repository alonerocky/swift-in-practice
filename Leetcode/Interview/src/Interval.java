import java.util.*;

/**
 * Created by shoulongli on 3/11/16.
 */
public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            List<Interval> result = new ArrayList<>();
            result.add(newInterval);
            return result;
        }
        int i = 0;
        while (i < intervals.size()) {
            Interval current = intervals.get(i);
            if (!hasOverlap(current, newInterval)) {
                if (newInterval.start > current.end) {
                    i++;
                } else if (newInterval.end < current.start) {
                    //insert it and break;
                    intervals.add(i, newInterval);
                    break;
                }
            } else {
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);
                intervals.remove(i); //i+1, will become the i, and continue
            }
        }
        if (i == intervals.size() )
        {
            intervals.add(newInterval);
        }
        return intervals;
    }

    private boolean hasOverlap(Interval i1, Interval i2) {
        return !(i1.end < i2.start || i1.start > i2.end);
    }

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
//    private Comparator<Interval> comparator = new Comparator<Interval>() {
//        @Override
//        public int compare(Interval o1, Interval o2) {
//            if (o1.start < o2.start) {
//                return -1;
//            } else if (o1.start > o2.start) {
//                return 1;
//            } else {
//                if (o1.end == o2.end) {
//                    return 0;
//                } else if (o1.end < o2.end) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        }
//    };

    public List<Interval> mergeII(List<Interval> intervals) {
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                } else {
                    if (o1.end < o2.end) {
                        return -1;
                    } else if (o1.end > o2.end) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        };
        if (intervals == null || intervals.size() <= 0) {
            return intervals;
        }

        Collections.sort(intervals, comparator );

        int i = 1;
        while (i < intervals.size()) {
            Interval previous = intervals.get(i-1);
            Interval current = intervals.get(i);

            if (hasOverlap(previous, current)) {
                previous.start = Math.min(previous.start, current.start);
                previous.end = Math.max(previous.end, current.end);
                intervals.remove(i);
            } else {
                i++;
            }

        }
        return intervals;
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        //earlies start time is optimal
        Comparator<Interval> comparator1 = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) {
                    return i1.end - i2.end;
                } else {
                    return i1.start - i2.start;
                }
            }
        };
        Comparator<Interval> comparator2 = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.end == i2.end) {
                    return i2.start - i1.start;
                } else {
                    return i2.end - i1.end;
                }
            }
        };
        //the biggest end time is always on top
        Arrays.sort(intervals, comparator1);
        ArrayList<PriorityQueue<Interval>> rooms = new ArrayList<PriorityQueue<Interval>>();
        PriorityQueue<Interval> room1 = new PriorityQueue<Interval>(5, comparator2);
        room1.offer(intervals[0]);
        rooms.add(room1);
        int roomNum = 1;
        for (int i =1; i < intervals.length; i++) {

            boolean isCompatible = false;
            for (int j = 0; j < rooms.size(); j++) {
                PriorityQueue<Interval> oneRoom = rooms.get(j);
                Interval maxEnd = oneRoom.peek();
                if (intervals[i].start >= maxEnd.end) {
                    //compatible
                    oneRoom.offer(intervals[i]);
                    isCompatible = true;
                    break;
                }
            }
            if (!isCompatible) {
                PriorityQueue<Interval> newRoom = new PriorityQueue<Interval>(5, comparator2);
                newRoom.offer(intervals[i]);
                rooms.add(newRoom);
            }
        }
        return rooms.size();
    }
}
