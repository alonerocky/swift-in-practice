public List<Integer> majorityElement(int[] nums) {
        int[] candidate = new int[2];
        int[] numOfCandidate = new int[2];

        for (int i =0 ;i < nums.length; i++) {
            int num = nums[i];
            //if they are both empty
            if (numOfCandidate[0] == 0 && numOfCandidate[1] == 0) {
                candidate[0] = num;
                numOfCandidate[0] ++;
            } else if (numOfCandidate[0] > 0 && numOfCandidate[1] == 0) { //1 is not empty, but 2 is empty
                if (num == candidate[0]) {
                    numOfCandidate[0]++;
                } else {
                    candidate[1] = num;
                    numOfCandidate[1] = 1;
                }

            } else if (numOfCandidate[1] > 0 && numOfCandidate[0] == 0) { //2 is not empty , but 1 is empty
                if (num == candidate[1]) {
                    numOfCandidate[1] ++;
                } else {
                    candidate[0] = num;
                    numOfCandidate[0] = 1;
                }
            } else { //both are not empty
                if (num == candidate[0]) {
                    numOfCandidate[0]++;
                } else if (num == candidate[1]) {
                    numOfCandidate[1]++;
                } else {
                    numOfCandidate[0]--;
                    numOfCandidate[1]--;
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        if (numOfCandidate[0] > 0) {

            for (int i = 0; i < nums.length; i++) {
                if (candidate[0] == nums[i]) {
                    count++;
                }
            }
            if (count > nums.length / 3) {
                result.add(candidate[0]);
            }
        }
        count = 0;
        if (numOfCandidate[1] > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (candidate[1] == nums[i]) {
                    count++;
                }
            }
            if (count > nums.length / 3) {
                result.add(candidate[1]);
            }
        }
        return result;
    }
    
    public List<Integer> majorityElementII(int[] nums) {
        return majorityElement(nums, 3);
    }
    public List<Integer> majorityElement(int[] nums, int k) {
        //find all element appear more than n/k times, we will conver it to k-bag problems
        //int k = 3;
        int KBAG_SIZE = k -1;
        HashMap<Integer, Integer> kBag = new HashMap<Integer, Integer>(KBAG_SIZE);
        for (int i = 0;i < nums.length; i++) {
            int num = nums[i];
            if (kBag.containsKey(num)) {
                kBag.put(num, kBag.get(num) + 1); //already in bad, increase 1
            } else if (kBag.size() < KBAG_SIZE) {
                kBag.put(num, 1); //never show up
            } else {
                //new element ,and also the kbag is full, we need decrase all the element in the k-1 bag and
                //that means we drop num and the k-1 element in the bag
                Iterator<Integer> iterator = kBag.keySet().iterator();
                int keyToRemove = 0;
                while (iterator.hasNext()) {
                    int key = iterator.next();
                    int count = kBag.get(key);
                    if (count == 1) {
                        keyToRemove = key;
                    } else {
                        kBag.put(key, kBag.get(key) - 1);
                    }

                }
                kBag.remove(keyToRemove);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iterator = kBag.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            //verify if the element left in the kbag are majority element
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    count++;
                }
            }
            if (count > nums.length / k) {
                result.add(key);
            }
        }
        return result;
    }
