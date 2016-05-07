public int minMeetingRooms(Interval[] intervals) {
          if (intervals == null || intervals.length == 0) {
              return 0;
          }
          int n = intervals.length;
          int[] start = new int[n];
          int[] end = new int[n];
          for (int i =0; i < n; i++) {
              Interval interval = intervals[i];
              start[i] = interval.start;
              end[i] = interval.end;
          }
          Arrays.sort(start);
          Arrays.sort(end);
          
          int startP = 0;
        int endP = 0;
         
        int numActive = 0;
        int numOverlap = 0;
         
        while (startP < start.length && endP < end.length) {
            if (start[startP] < end[endP]) {
                numActive++;
                numOverlap = Math.max(numOverlap, numActive);
                startP++;
            } else {
                numActive--;
                endP++;
            }
        }
        return numOverlap;
    }

----------------

public int minMeetingRooms(Interval[] intervals) {
         if (intervals == null || intervals.length == 0) {
             return 0;
         }
         //sort the intervals by start time
         Comparator<Interval> comparator = new Comparator<Interval>(){
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
         ArrayList<ArrayList<Interval>> rooms = new ArrayList<ArrayList<Interval>>();
         for (int i = 0; i < intervals.length; i++) {
             Interval interval = intervals[i];
             boolean isCompatible = false;
             int j = 0;
             for(; j < rooms.size();j++) {
                 ArrayList<Interval> room = rooms.get(j);
                 if (room.get(room.size() - 1).end <= interval.start) {
                     isCompatible = true;
                     break;
                 }
             }
             if (isCompatible)  {
                 rooms.get(j).add(interval);
             } else {
                 ArrayList<Interval> newRoom = new ArrayList<Interval>();
                 newRoom.add(interval);
                 rooms.add(newRoom);
             }
         }
         return rooms.size();
    }
