public int singleNumber(int[] nums) {
        //https://www.careercup.com/question?id=7902674
        //http://www.acmerblog.com/leetcode-single-number-ii-5394.html
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int i =0 ;i < nums.length; i++) {
            twos |= ones & nums[i];
            ones ^= nums[i];
            threes = ones & twos;
            ones &= ~threes; //remvove the element appeared three times from ones
            twos &= ~threes; //remvove the element appeared three times from twos
        }
        return ones;
    }

public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for (int i =0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1 ) != 0) {
                    count[i] ++;
                }
            }
            result |=  (count[i] % 3) << i;
        }
        return result;
        
    }
