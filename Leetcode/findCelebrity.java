public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i =0;i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b) ) { //a not the celebrity
                stack.push(b);
            } else { //b not celebrity
                stack.push(a);
            }
        }
        int maybeCelebrity = stack.pop();
        if (isCelebrity(maybeCelebrity, n)) {
            return maybeCelebrity;
        }
        return -1;

    }
    public boolean isCelebrity(int a, int n) {
        for (int i = 0; i < n; i++) {
            if (i != a) {
                if (knows(a, i) || !knows(i, a) ) {
                    return false;
                }
            }
        }
        return true;
    }
