public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        } else if (nums.length == 0) {
            return nums;
        } 
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] * nums[i-1];
            right[len-1-i] = right[len-i] * nums[len-i];
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
         
        int[] out = new int[n]; 
        out[0] = 1;
        for (int i = 1; i < n; i++) {
            out[i] = out[i-1] * nums[i-1]; 
        }
        
        int post = 1;
        for (int i = n-2; i>=0;i--) {
            post = post * nums[i+1];
            out[i] = out[i] * post;
        }
        
        return out;
    }
