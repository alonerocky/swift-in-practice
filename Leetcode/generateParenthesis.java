public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        tryNextOne(result, sb, n, 0);
        return result;
    }
    
    private void tryNextOne(List<String> result, StringBuffer sb,  int n, int i) {
        if (i == n + n && isValid(sb.toString(), true)) {
            result.add(sb.toString());
            return ;
        } else if (i < n+n) {
            
            //try left
            
            if (isValid(sb.toString() + "(", false)) {
                sb.append("(");
                tryNextOne(result, sb, n, i+1);
                sb.deleteCharAt(sb.length() -1);
            }
            
            if (isValid(sb.toString() + ")", false)) {
                sb.append(")");
                tryNextOne(result, sb, n, i+1); 
                sb.deleteCharAt(sb.length() -1);
            } 
        }  
    }
    
    public boolean isValid(String p, boolean complete) {
        if (p == null || p.length() == 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right ++;
                if (right > left) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return complete ? (left == right) : true;
    }
