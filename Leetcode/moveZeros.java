public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        int numOfZeros = 0;
        while (start <= end) {
            if (nums[start] != 0) {
                start++;
            } else if (nums[end] == 0) {
                end--;
            } else {
                //start now point to 0
                int i = start + 1;
                while (i <= end && nums[i] == 0) i++;
                numOfZeros += (i - start);
                //[start, i-1] are all zeros
                //move [i, end] to [start, start + end - i]
                System.arraycopy(nums, i, nums, start, end - i + 1);
                end = start + end - i;
                start++;
            }
        }
        
        //[end +1, length -1]
        //length -1 -end = size
        if (nums.length -1 - end > 0) {
            Arrays.fill(nums, end + 1, nums.length , 0);
        }
    }


//
public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i =0; 
        int len = nums.length;
        while (i < len) {
            if (nums[i] != 0) {
                i++;
                continue;
            } 
            //nums[i] = 0;
            int j = i + 1;
            while (j < len && nums[j] == 0) {
                j++;
            }
            if (j == len) {
                break;
            }
            //j point to either the end or the one not zero
            int zeros = j - i;
            //move [j, len-1] to [i, ]
            System.arraycopy(nums, j, nums, i, len - j);
            len -= zeros;
        }
        if (len < nums.length) {
            Arrays.fill(nums, len, nums.length, 0);
        }
        
    }
