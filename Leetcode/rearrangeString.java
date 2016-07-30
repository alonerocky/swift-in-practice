public String rearrangeString(String str, int k) {
        if (str == null) {
            return "";
        }
        if (k == 0) {
            return str;
        }
        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                if (e1.getValue().intValue() == e2.getValue().intValue()) {
                    return e1.getKey() - e2.getKey();
                }
                return e2.getValue() - e1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(k, comparator);
        //build the map
        buildMaxHeap(str, maxHeap);

        //
        StringBuffer sb = new StringBuffer();
        while(!maxHeap.isEmpty()) {
            int n = Math.min(maxHeap.size(), k);
            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>();
            for(int i = 0; i < n; i++) {
                list.add(maxHeap.poll());
            }
            for(int i = 0; i < n; i++) {
                Map.Entry<Character, Integer> entry = list.get(i);
                sb.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }
            if (n < k && maxHeap.size() > 0) {
                return "";
            }
        }
        return sb.toString();
    }
    public void buildMaxHeap(String str, PriorityQueue<Map.Entry<Character, Integer>> maxHeap) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
         for(int i =0; i < str.length(); i++) {
             char c = str.charAt(i);
             if (map.containsKey(c)) {
                 map.put(c, map.get(c) + 1);
             } else {
                 map.put(c, 1);
             }
         }
         Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
         while(iterator.hasNext()) {
             maxHeap.offer(iterator.next());
         }
    }
