public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else if (map.size() < k - 1) {
                map.put(num, 1);
            } else {
                //already got k elememtn, 
                //decrease the times for each element, if become zero ,remove it
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                while(iterator.hasNext()) {
                    Map.Entry<Integer,Integer> entry = iterator.next();
                    entry.setValue(entry.getValue() - 1);
                    if (entry.getValue() == 0) {
                        iterator.remove();
                    }
                }
            }
        }
        
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            int num = iterator.next();
            int count = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == num) {
                    count++;
                }
            }
            if (count > nums.size() / k) {
                return num;
            }
        }
        return -1;
    }
