public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null ) {
            return result;
        }
        HashSet<String> set = new HashSet<String>();
        set.add(s);
        Deque<String> queue = new ArrayDeque<String>();
        queue.addLast(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String one = queue.pollFirst();
            if (isValid(one)) {
                found = true;
                result.add(one);
            }
            if(!found){
                for (int i = 0; i < one.length(); i++) {
                    char c = one.charAt(i);
                    if (c != '(' && c != ')') continue;
                    String str = one.substring(0,i) + one.substring(i+1);
                    if (set.add(str)) {
                        queue.addLast(str);
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s) {
        int count = 0;
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0 ) {
                    return false;
                }
            }
        }
        return count == 0;
    }
