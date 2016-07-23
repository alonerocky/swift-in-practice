public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        Comparator<Entry> comparator = new Comparator<Entry>() {
            @Override
            public int compare(Entry e1, Entry e2) {
                return e1.sum - e2.sum;
            }
        };
        
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(comparator);
        Entry one = new Entry(0, 0, nums1[0] + nums2[0]);
        HashSet<Entry> set = new HashSet<Entry>();
        minHeap.offer(one);
        set.add(one);
        for(int i = 0; i < k; i++) {
            if (minHeap.isEmpty()) {
                break;
            }
            Entry min = minHeap.poll();
            int[] r = new int[2];
            r[0] = nums1[min.i];
            r[1] = nums2[min.j];
            result.add(r);
            if (min.i < nums1.length - 1) {
                Entry e = new Entry(min.i+1,min.j,nums1[min.i+1] + nums2[min.j]);
                if (set.add(e))
                    minHeap.offer(e);
            }
            if (min.j < nums2.length - 1) {
                Entry e = new Entry(min.i, min.j+1, nums1[min.i] + nums2[min.j+1]);
                if (set.add(e))
                    minHeap.offer(e);
            }

        }
        return result;
    }



------------------
public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]> result = new ArrayList<int[]>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        HashSet<Entry> set = new HashSet<Entry>();
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(k);
        minHeap.offer(new Entry(0,0, nums1[0] + nums2[0]));
        int i = 0;
        int j = 0;
        int index = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while(!minHeap.isEmpty() && index < k) {
            
            Entry front = minHeap.poll();
            int[] one = new int[2];
            one[0] = nums1[front.i];
            one[1] = nums2[front.j];
            index++;
            result.add(one);
            if (front.j + 1 < len2) {
                Entry next = new Entry(front.i, front.j + 1, nums1[front.i] + nums2[front.j + 1]);
                if (set.add(next)) {
                    minHeap.offer(next);
                }
            }
            if (front.i + 1 < len1) {
                Entry next = new Entry(front.i + 1, front.j, nums1[front.i + 1] + nums2[front.j]);
                if (set.add(next)) {
                    minHeap.offer(next);
                }
            }
        }
        
        return result;
    }
    class Entry implements Comparable<Entry> {
        public int i;
        public int j;
        public int value;
        public Entry(int i , int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
        @Override
        public int hashCode() {
            return this.i << 14 & this.j << 7 & this.value;
        }
        
        @Override
        public int compareTo(Entry e) {
            return this.value - e.value;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Entry)) {
                return false;
            }
            if (o == this) {
                return true;
            }
            Entry other = (Entry)o;
            return this.i == other.i && this.j == other.j && this.value == other.value;
        }
    }
