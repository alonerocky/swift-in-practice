public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] ++;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
            
        }
        return max;
        
    }
    
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> hStack = new Stack<Integer>();
        Stack<Integer> leftStack = new Stack<Integer>();
        int max = 0;
        for (int i =0; i < heights.length; i++) {
            if (hStack.isEmpty() || hStack.peek() < heights[i]) {
                hStack.push(heights[i]);
                leftStack.push(i);
            } else if (hStack.peek() > heights[i]) {
                
                int left = leftStack.peek();
                while (!hStack.isEmpty() && heights[i] < hStack.peek()) {
                    left = leftStack.pop();
                    int h = hStack.pop();
                    max = Math.max(max, (i - left) * h);
                }
                hStack.push(heights[i]);
                leftStack.push(left);
            }
        }
        int right = heights.length;
        while (!hStack.isEmpty()) {
            int left = leftStack.pop();
            int h = hStack.pop();
            max = Math.max(max, (right - left) * h);
        }
        return max;
    }
