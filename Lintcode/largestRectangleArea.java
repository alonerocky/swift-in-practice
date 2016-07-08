public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        int len = height.length;
        for(int i = 0; i < len; i++) {
            int h = height[i];
            int left = i;
            int right = i;
            while(left >= 0 && height[left] >= height[i]) {
                left--;
            }
            while(right < len && height[right] >= height[i]) {
                right++;
            }
            //[left+1, right-1];
            max = Math.max(max, (right - left - 1) * h);
            
        }
        return max;
     }
    public int largestRectangleAreaII(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> hStack = new Stack<Integer>();
        Stack<Integer> indexStack = new Stack<Integer>();
        int max = 0;
        int len = height.length;
        for(int i =0; i < len; i++) {
            int h = height[i];
            if (hStack.isEmpty() || h > hStack.peek()) {
                hStack.push(h);
                indexStack.push(i);
            } else if (h< hStack.peek()) {
                int index = 0;
                while(!hStack.isEmpty() && hStack.peek() > h) {
                    index = indexStack.pop();
                    int hh = hStack.pop();
                    max = Math.max(max,  (i-index) * hh);
                }
                hStack.push(h);
                indexStack.push(index);
            }
            
        }
        while(!hStack.isEmpty()) {
            int h = hStack.pop();
            int index = indexStack.pop();
            max = Math.max(max, (len - index) * h);
        }
        
        return max;
    }
