public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return null;
        }
        Stack<ExpressionTreeNode> numStack = new Stack<ExpressionTreeNode>();
        Stack<Character> opStack = new Stack<Character>();
        for (int i = 0; i < expression.length; i++) {
            String exp = expression[i];
            if (isOperator(exp)) {
                char c = exp.charAt(0);
                if (c == ')') {
                    while(!opStack.isEmpty() && opStack.peek() != '(') {
                        if (opStack.isEmpty() || numStack.size() < 2) {
                            return null;
                        }
                        compute(numStack, opStack);
                    }
                    opStack.pop();
                } else {
                    while(!opStack.isEmpty() && needCompute(opStack.peek(), c)) {
                        if (opStack.isEmpty() || numStack.size() < 2) {
                            return null;
                        }
                        compute(numStack, opStack);
                    }
                    opStack.push(c);
                }
            } else {
                ExpressionTreeNode node = new ExpressionTreeNode(exp);
                numStack.push(node);
            }
        }
        while(!opStack.isEmpty()) {
            compute(numStack, opStack);
        }
        if (numStack.isEmpty()) {
            return null;
        }
        return numStack.pop();
    }
    public boolean needCompute(char left, char right) {
        switch(right) {
            case '(':
                return false;
            case '*':
            case '/':
                return left == '*' || left == '/';
            case '+':
            case '-':
                return left != '('; //* / + - takes precedence
        }
        return false;
    }
    public boolean isOperator(String s) {
        if (s.length() != 1) {
            return false;
        }
        char c = s.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    public void compute(Stack<ExpressionTreeNode> numStack, Stack<Character> opStack) {
        ExpressionTreeNode num2 = numStack.pop();
        ExpressionTreeNode num1 = numStack.pop();
        char c = opStack.pop();
        ExpressionTreeNode result = new ExpressionTreeNode(String.valueOf(c));
        result.left = num1;
        result.right = num2;
        numStack.push(result);
    }

    class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;

        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }
