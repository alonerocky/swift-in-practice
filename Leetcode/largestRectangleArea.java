public int largestRectangleArea(int[] height) 
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null || height.length == 0)
            return 0; 
        java.util.Stack<Integer> heightStack = new java.util.Stack<Integer>();
        java.util.Stack<Integer> leftIndexStack = new java.util.Stack<Integer>();
        int max = 0; 
        //the elements in the height stack is " the rectangle with the height of "
        for(int i = 0;i < height.length; i++)
        {               
            if(heightStack.isEmpty() || heightStack.peek().intValue() < height[i])
            {
                heightStack.push(height[i]);
                leftIndexStack.push(i);
            }
            else if(heightStack.peek().intValue() > height[i])
            {
                int left = 0;
                while(!heightStack.isEmpty() && heightStack.peek().intValue() > height[i] )
                {
                    left = leftIndexStack.pop();                        
                    int area = (i - left) * heightStack.pop();
                    if(area > max)
                        max = area;
                }
                heightStack.push(height[i]);
                leftIndexStack.push(left);                   
            }
        }           
        int right = height.length;
        while(!heightStack.isEmpty())
        {               
            int left = leftIndexStack.pop();
            int area = (right - left) * heightStack.pop();
            if(area > max)
                max = area;             
        }
        return max;
    }
