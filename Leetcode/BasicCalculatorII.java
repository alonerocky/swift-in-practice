public int calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        s = s.trim();
        int i = 0;
        int len = s.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                String str = s.substring(i, j);
                numStack.push(Integer.parseInt(str));
                i = j;
            } else if (c == ' ') {
                i++;
            } else {
                while (!opStack.isEmpty() && needCalculate(opStack.peek(), c)) {
                    compute(opStack, numStack);
                }
                opStack.push(c);
                i++;
            }
        }
        while (!opStack.isEmpty()) {
            compute(opStack, numStack);
        }
        return numStack.pop();
    }
    
    //check the precedence
    //true , means left need calculte before push right
    //false m
    public boolean needCalculate(char left, char right) {
        //left
        switch(right) {
            case '+':
            case '-':
                return (left == '+' || left == '-' || left == '*' || left == '/' || left == '%');
            case '*':
            case '/':
            case '%':
                return left == '*' || left == '/' || left == '%';
            case '(':
                return false;
            case ')':
                return true;
        }
        return false;
    }
    
    public void compute(Stack<Character> opStack, Stack<Integer> numStack) {
        char c = opStack.pop();
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        switch(c) {
            case '+':
                numStack.push(num1+num2);
                break;
            case '-':
                numStack.push(num1-num2);
                break;
            case '*':
                numStack.push(num1 * num2);
                break;
            case '/':
                numStack.push(num1/num2);
                break;
            case '%':
                break;
            default:
                break;
        }
    }


//lintcode Expression Evaluation
public int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return 0;
        }
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();
        for (int i =0; i < expression.length; i++) {
            String token = expression[i];
             
            if (token.length() == 1 && isOperator(token.charAt(0))) {
                char op = token.charAt(0);
                if (op == ')') {
                    while(!opStack.isEmpty() && opStack.peek() != '(') {
                        compute(numStack, opStack);
                    }
                    opStack.pop(); //pop up ()
                    
                } else {
                    while(!opStack.isEmpty() && needCompute(opStack.peek(), op)) {
                        compute(numStack, opStack);
                    }
                    opStack.push(op);
                }
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        while(!opStack.isEmpty()) {
            compute(numStack, opStack);
        }
        if (numStack.isEmpty()) {
            return 0;
        }
        return numStack.pop();
    }
    public boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/' || op == '(' || op == ')';
    }
    public boolean needCompute(char op1, char op2) {
        switch(op2) {
            case '(':
                return false;
            case '+':
            case '-':
                return op1 != '(';
            case '*':
            case '/':
                return op1 == '*' || op1 == '/';
        }
        return false;
    }
    public void compute(Stack<Integer> numStack, Stack<Character> opStack) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        char op = opStack.pop();
        switch(op) {
            case '+':
                numStack.push(num1+num2);
                break;
            case '-':
                numStack.push(num1-num2);
                break;
            case '*':
                numStack.push(num1*num2);
                break;
            case '/':
                numStack.push(num1/num2);
                break;
        }
    }
