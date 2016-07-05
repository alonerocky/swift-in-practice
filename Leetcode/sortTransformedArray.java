public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len];
        if (a == 0) {
            if (b >= 0) {
                for(int i = 0; i < len; i++) {
                    result[i] = b * nums[i] + c;
                }
            } else {
                for(int i = 0; i < len; i++) {
                    result[len-1-i] = b * nums[i] + c;
                }
            }
        } else if (a > 0) {
            double middle = -b/(2.0 * a);
            int start = 0;
            int end = len-1;
            int index = len-1;
            while(start <= end) {
                if (Math.abs(nums[start] - middle) < Math.abs(nums[end] - middle)) {
                    result[index--] = a * nums[end] * nums[end] + b * nums[end] + c;
                    end--;
                } else {
                    result[index--] = a * nums[start] * nums[start] + b * nums[start] + c;
                    start++;
                }
            }
        } else if (a < 0) {
            double middle = -b/(2.0*a);
            int start = 0;
            int end = len-1;
            int index = 0;
            while(start <= end) {
                if (Math.abs(nums[start] - middle) < Math.abs(nums[end] - middle)) {
                    result[index++] = a * nums[end] * nums[end] + b * nums[end] + c;
                    end--;
                } else {
                    result[index++] = a * nums[start] * nums[start] + b * nums[start] + c;
                    start++;
                }
            }
        }
        return result;
    }
