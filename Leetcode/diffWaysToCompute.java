public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return result;
        } else {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!isOperator(c) ) {
                    continue;
                }
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l = 0 ; l < left.size() ; l++) {
                    for (int r = 0; r < right.size() ; r++) {
                        result.add(calculate(left.get(l),right.get(r),c));
                    }
                }
            }
            if (result.isEmpty()) { //doesn't contain operator
                result.add(Integer.parseInt(input));
            }
            return result;
        }
    }
    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    public int calculate(int num1, int num2, char c) {
        switch(c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }
