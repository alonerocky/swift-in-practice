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
