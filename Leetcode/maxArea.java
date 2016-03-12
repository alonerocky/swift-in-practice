public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        if (height == null || height.length == 0) {
            return 0;
        }
        int i =0;
        int j = height.length - 1;
        while (i < j) {
            int width = j - i;
            int high = Math.min(height[i], height[j]);
            max = Math.max(max, width * high);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
