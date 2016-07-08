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
