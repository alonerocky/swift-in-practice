public int missingNumberI(int[] nums) {
         //if we add 0..n again
         //it will become "n element become twice , only one single number appear single, find it"
         int single = 0;
         for (int i = 0;i < nums.length; i++) {
             single ^= nums[i]; 
             single ^= (i + 1); //[0, 1 .. n]
         }
         return single;
    }
    public int missingNumberII(int[] nums) {
        long total = 0;
        for (int i = 0;i < nums.length; i++) {
            total += nums[i];
        }
        int n = nums.length;
        return (int)((1+n) * n /2 - total);
    }
    
    public int missingNumberIII(int[] nums) {
        Arrays.sort(nums);
        int i =0; 
        int j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > k) {
                return k;
            }
        }
        return nums.length;
    }
    
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i =0; 
        int j = nums.length ;
        while (i < j) {
            int middle = (i + j) /2;
            if (nums[middle] > middle) {
                j = middle;
            } else {
                i = middle + 1 ;
            }
        }
        return j;
    }
