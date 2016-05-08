public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
              return entry1.getValue() - entry2.getValue();
          }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>> (k, comparator);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            
            if (minHeap.size() < k) {
                minHeap.offer(entry);
                 
            } else if (comparator.compare(entry, minHeap.peek()) > 0) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator2 = minHeap.iterator();
        while(iterator2.hasNext()) {
            result.add(0, iterator2.next().getKey());
        }
        return result;
    }
