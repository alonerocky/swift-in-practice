https://segmentfault.com/a/1190000003874375
public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stk = new Stack<Integer>();
        // 初始化最小值为最小整数
        int min = Integer.MIN_VALUE;
        for(int num : preorder){
            // 违反最小值限定则是无效的
            if(num < min) return false;
            // 将路径中所有小于当前的数pop出来并更新最小值
            while(!stk.isEmpty() && num > stk.peek()){
                min = stk.pop();
            }
            // 将当前值push进去
            stk.push(num);
        }
        return true;
    }


http://buttercola.blogspot.com/2015/09/leetcode-verify-preorder-sequence-in.html
public boolean verifyPreorder(int[] preorder) {
       if (preorder == null || preorder.length == 0) {
           return true; //empty true
       }
       Stack<Integer> stack = new Stack<Integer>();
       int max = Integer.MIN_VALUE;
       for (int i = 0; i < preorder.length; i++) {
           
           int num = preorder[i];
           if (num < max) {
               return false;
           }
           while (!stack.isEmpty() && num > stack.peek()) {
               max = stack.pop(); //get the max from root and left children 
           }
           stack.push(num);
       }
       return true;
    }
    
    public boolean verifyPreorderII(int[] preorder) {
       if (preorder == null || preorder.length == 0) {
           return true; //empty true
       }
       return verifyPreorder(preorder, 0, preorder.length - 1);
    }
    
    public boolean verifyPreorder(int[] preorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = preorder[left];
        int i = left+1;
        while (i <= right && preorder[i] < root) {
            i++;
        }
        if (!verifyPreorder(preorder, left + 1, i-1)) {
            return false;
        }
        int j = i;
        while (j <= right && preorder[j] > root) {
            j++;
        }
        //j should point to right + 1
        if (j <= right) {
            return false;
        }
        
        return verifyPreorder(preorder, i, j-1);
        
    }
