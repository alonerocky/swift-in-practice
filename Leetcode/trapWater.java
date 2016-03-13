public int trap(int[] height) {
        
        if (height == null || height.length <=2) {
            return 0;
        }
        
        int i =0; 
        int j = height.length - 1;
        int result = 0;
        while (i < j) {
            if (i < j && height[i] <= height[i+1]) {
                i++;
            } else if (i < j && height[j] <= height[j-1]) {
                j--;
            } else {
                if (height[i] <= height[j]) {
                    int k = i + 1;
                    while (k < j && height[k] <= height[i]) 
                    {
                        result += (height[i] - height[k]);
                        k++;
                    }
                    i = k;
                } else {
                    int k = j - 1;
                    while (k > i && height[k] <= height[j]) {
                        result += (height[j] - height[k]);
                        k--;
                    }
                    j = k;
                }
            }
        }
        return result;
    }
