//find repeated element  n/k times
public int majorityElement(int[] nums) {
       
       int candidate = nums[0];
       int count = 1;
       for (int i =1;i < nums.length; i++) {
           
           if (count == 0) {
               candidate = nums[i];
               count++;
           } else if (nums[i] == candidate) {
               count++;
           } else {
               count--;
           }
       }
       return candidate;
    }



public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        int size = nums.length;
        int result = -1;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < size; i++) {
            int num = nums[i];
            if (hashMap.containsKey(num)) {
                int count = hashMap.get(num);
                count ++;
                if (count > size /2) {
                    result = num;
                    break;
                }
                hashMap.put(num, count );
            } else {
                hashMap.put(num, 1);
                
            }
        }
        return result;
    }
