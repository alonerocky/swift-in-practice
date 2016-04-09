private List<String> res = new ArrayList<String>();
    private int max = 0;
    public List<String> removeInvalidParentheses(String s) {
        dfs(s, "", 0, 0);
        if (res.size() == 0) {
            res.add("");
        }

        return res;
    }
    /*
    http://blog.csdn.net/foreverling/article/details/49740665
    括号总是成对出现的，因此我们只需要记录尚未匹配的（。 
每次循环时有如下三种情况：

(, 保留或者不保留。
), 如果我们有未匹配的（，则有两种选择；否则，只能不保留。
保留其他字符。
因为我们要移除数量最少的括号，我们应该得到最大的匹配（）数量，注意下面两行的顺序。

dfs(str.substring(1), subRes + '(', countLeft + 1, maxLeft + 1);
dfs(str.substring(1), subRes, countLeft, maxLeft);
1
2
它可以保证最长的结果出现在比它较短的结果前面。
    */
    private void dfs(String str, String subRes, int countLeft, int maxLeft) {
        if (str.length() == 0) {
            if (countLeft == 0 && subRes.length() != 0) {
                if (maxLeft > max) {
                    max = maxLeft;
                }
                if (max == maxLeft && !res.contains(subRes)) {
                    res.add(subRes.toString());
                }
            }
            return;
        }

        if (str.charAt(0) == '(') {
            //keep (
            dfs(str.substring(1), subRes.concat("("), countLeft + 1, maxLeft + 1);
            //discard (
            dfs(str.substring(1), subRes, countLeft, maxLeft);
        } else if (str.charAt(0) == ')') {
            if (countLeft > 0) {
                //keep )
                dfs(str.substring(1), subRes.concat(")"), countLeft - 1, maxLeft);
            }
            //discard )
            dfs(str.substring(1), subRes, countLeft, maxLeft);
        } else {
            dfs(str.substring(1), subRes.concat(String.valueOf(str.charAt(0))), countLeft, maxLeft);
        }
    }

    
    
    
    public List<String> removeInvalidParentheses_bfs(String s) {
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
