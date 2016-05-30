package Facebook;


import java.util.*;


/**
 * Created by shoulongli on 5/10/16.
 */
public class Facebook {

    public static void main(String[] argv) {
        String[][] contacts = {{"Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"},
                {"Lucky", "lucky@gmail.com", "+1234567"},
                {"gaurav123", "+5412312", "gaurav123@skype.com"},
                {"gaurav1993", "+5412312", "gaurav@gfgQA.com"},
                {"raja", "+2231210", "raja@gfg.com"},
                {"bahubali", "+878312", "raja"}
        };

        String[][] contacts2 = {{ "John", "john@gmail.com", "john@fb.com"},
        {"Dan", "dan@gmail.com", "+1234567"},
        { "john123", "+5412312", "john123@skype.com"},
        { "john1985", "+5412312", "john@fb.com"}};
        Facebook f = new Facebook();
        System.out.println(f.findSameContact(contacts));
        System.out.println(f.findSameContact(contacts2));

        System.out.println(f.revertWord("the boy ran"));
//        int[][] dominos = {{2,5},{3,4},{3,2}};
//        System.out.println(f.findDominoPair(dominos));

        /*
        isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
         */
        System.out.println(f.isMatch("aa","a") == false);
        System.out.println(f.isMatch("aa","aa") == true);
        System.out.println(f.isMatch("aaa","aa") == false);
        System.out.println(f.isMatch("aa","*") == true);
        System.out.println(f.isMatch("aa","a*") == true);
        System.out.println(f.isMatch("ab","?*") == true);
        System.out.println(f.isMatch("aab","c*a*b*") == false);

        System.out.println(f.isMatchII("aa","a") == false);
        System.out.println(f.isMatchII("aa","aa") == true);
        System.out.println(f.isMatchII("aaa","aa") == false);
        System.out.println(f.isMatchII("aa","*") == true);
        System.out.println(f.isMatchII("aa","a*") == true);
        System.out.println(f.isMatchII("ab","?*") == true);
        System.out.println(f.isMatchII("aab","c*a*b*") == false);

        System.out.println(f.isMatchIII("aa","a") == false);
        System.out.println(f.isMatchIII("aa","aa") == true);
        System.out.println(f.isMatchIII("aaa","aa") == false);
        System.out.println(f.isMatchIII("aa","*") == true);
        System.out.println(f.isMatchIII("aa","a*") == true);
        System.out.println(f.isMatchIII("ab","?*") == true);
        System.out.println(f.isMatchIII("aab","c*a*b*") == false);
        System.out.println(f.numSquares(1));

        int[] input = {2,3,5,7,8,9,-2,-5,10,-4};
        System.out.println(f.findNumbers(input, 1));
        System.out.println(f.taskRun("AAABBB", 2).equals("A__A__AB__B__B"));
        System.out.println(f.taskScheduler("AAABBB", 2).equals("AB_AB_AB"));

        System.out.println(f.taskRun("ABCDAABA", 2).equals("ABCDA__AB_A"));
        System.out.println(f.taskScheduler("ABCDAABA", 2).equals("ABCABDA__A"));

        System.out.println(f.taskRun("AABABCD", 2).equals("A__AB_ABCD"));
        System.out.println(f.taskScheduler("AABABCD", 2).equals("ABCABDA"));

        System.out.println(f.getTime("AABABCD", 2));


//        System.out.println(f.parseFomularString("x - (y - (5 + 3y)) = 3y + 2x - 1", 2) == 4.0);
//        System.out.println(f.parseFomularString("5 + 2x - ( 3y + 2x - ( 7 - 2x) - 9 ) = 3 + 4y", 2) == 2.0);
//        System.out.println(f.parseFomularString("2y-(y+5)=3y+6", 2) == -5.5);
//        System.out.println(f.parseFomularString("10x + y = 2y - 10", 2) == 30);
//        System.out.println(f.parseFomularString("x + 5 + y = 2y - 3x - 10", 2) == 23);
        System.out.println(f.evaluate("x - (y - (5 + 3y)) = 3y + 2x - 1", 2) == 4.0);
        System.out.println(f.evaluate("5 + 2x - ( 3y + 2x - ( 7 - 2x) - 9 ) = 3 + 4y", 2) == 2.0);
        System.out.println(f.evaluate("2y-(y+5)=3y+6", 2) == -5.5);
        System.out.println(f.evaluate("10x + y = 2y - 10", 2) == 30);
        System.out.println(f.evaluate("x + 5 + y = 2y - 3x - 10", 2) == 23);

        int[] array = new int[] {4 ,2, 1, 5, 3};
        int[] position = new int[]{3, 1, 0, 4, 2};
        f.restoreArray(array, position);
        f.printArray(array);
        String[] words = { "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        System.out.println(f.alienOrder(words));
        System.out.println(f.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(f.longestConsecutive(new int[]{0,-1}));

        TreeNode t1 = f.buildTernaryTree(new char[]{'a','?','b',':','c'});
        TreeNode t1_II = f.buildTernaryTreeII(new char[]{'a','?','b',':','c'});
        System.out.println(TreeNode.sameTree(t1, t1_II));
        TreeNode t2 = f.buildTernaryTree(new char[]{'a','?','b',':','c','?','d',':','e'});
        TreeNode t2_II = f.buildTernaryTreeII(new char[]{'a','?','b',':','c','?','d',':','e'});
        System.out.println(TreeNode.sameTree(t2, t2_II));
        TreeNode t3 = f.buildTernaryTree(new char[]{'a','?','b','?','c',':','d',':','e'});
        TreeNode t3_II = f.buildTernaryTreeII(new char[]{'a','?','b','?','c',':','d',':','e'});
        System.out.println(TreeNode.sameTree(t3, t3_II));

        ArrayList<Log> recordLists = new ArrayList<>();
        recordLists.add(new Log("f1", 1, true));
        recordLists.add(new Log("f2", 3, true));
        recordLists.add(new Log("f2", 6, false));
        recordLists.add(new Log("f3", 7, true));
        recordLists.add(new Log("f4", 10, true));
        recordLists.add(new Log("f4", 11, false));
        recordLists.add(new Log("f3", 13, false));
        recordLists.add(new Log("f1", 20, false));
        recordLists.add(new Log("f5", 25, true));
        recordLists.add(new Log("f5", 30, false));

        HashMap<String, Long> map = f.checkFunctionTime(recordLists);
        Iterator<Map.Entry<String, Long>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Long> e = iterator.next();
            System.out.println(e.getKey()+"#=" + e.getValue());
        }

//        s1 = "aabcc",
//                s2 = "dbbca",
//
//                When s3 = "aadbbcbcac", return true.
//                When s3 = "aadbbbaccc", return false.
        System.out.println(f.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(f.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(f.isScramble("great","rgtae"));
        System.out.println(f.isScrambleII("great","rgtae"));
    }
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 1 && s2.length() == 1 && s1.charAt(0) == s2.charAt(0)) {
            return true;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (!Arrays.toString(array1).equals(Arrays.toString(array2))) {
            return false;
        }
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            String a = s1.substring(0,i);
            String b = s1.substring(i);

            String e = s2.substring(0,i);
            String f = s2.substring(i);

            if (isScramble(a,e) && isScramble(b,f)) {
                return true;
            }
            String g = s2.substring(0, len - i);
            String h = s2.substring(len -i);

            if (isScramble(a,h) && isScramble(b,g) ) {
                return true;
            }
        }
        return false;
    }

    public boolean isScrambleII(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 1 && s2.length() == 1) {
            if (s1.charAt(0) == s2.charAt(0)) {
                return true;
            } else {
                return false;
            }
        }

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (!Arrays.toString(array1).equals(Arrays.toString(array2))) {
            return false;
        }


        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            if (isScrambleII(s11, s21) && isScrambleII(s12, s22)) {
                return true;
            }

            s21 = s2.substring(0, s2.length() - i);
            s22 = s2.substring(s2.length() - i);

            if (isScrambleII(s11, s22) && isScrambleII(s12, s21)) {
                return true;
            }
        }

        return false;
    }


    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        tryAddOperator(num, 0, target, 0, 0, "", result);
        return result;
    }

    public void tryAddOperator(String num, int index, int target, long curSum, long preSum, String oneResult, List<String> result) {
        if (index == num.length() && curSum == target) {
            result.add(new String(oneResult));
        } else if (index < num.length()) {
            for (int i = index+1; i<= num.length();i++) {
                String str = num.substring(index, i);
                if (isValid(str)) {
                    long n = Long.parseLong(str);
                    if (oneResult.length() == 0) {

                        tryAddOperator(num, i, target, n, 0, str, result);
                    } else {
                        //+
                        tryAddOperator(num, i, target, curSum + n, n, oneResult + "+" + str, result);
                        //-
                        tryAddOperator(num, i, target, curSum - n, -n, oneResult+"-"+str, result);
                        //*
                        tryAddOperator(num, i, target, curSum - preSum + preSum * n, preSum * n, oneResult+"*"+str, result);
                    }
                }
            }
        }
    }
    public boolean isValid(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        if (num.length() == 0) {
            char c = num.charAt(0);
            return c >= '0' && c <= '9';
        } else {
            return num.charAt(0) != '0';
        }
    }

    //https://jiangchengl.wordpress.com/2015/11/01/facebook-on-site-interview-function-execution-time-in-a-log/
    //
    public HashMap<String, Long> checkFunctionTime(List<Log> logs) {
        HashMap<String, Long> result = new HashMap<String, Long>();
        if (logs == null || logs.size() == 0) {
            return result;
        }
        Stack<Record> stack = new Stack<Record>();
        for (int i = 0; i < logs.size(); i++) {
            Log log = logs.get(i);
            if (log.isStart) {
                Record r = new Record(log);
                r.gap = 0;
                stack.push(r);
            } else {
                Record top = stack.pop();
                long executionTime = log.timestamp - top.log.timestamp - top.gap;
                result.put(log.name, executionTime);
                if (!stack.isEmpty()) {
                    stack.peek().gap += top.gap + executionTime;
                }
            }
        }
        return result;
    }
    class Record {
        public Log log ;
        public int gap;
        public Record(Log log) {
            this.log = log;
        }

    }
    static class Log {
        public String name;
        public boolean isStart;
        public long timestamp;
        public Log(String name, long timestamp, boolean isStart) {
            this.name = name;
            this.timestamp = timestamp;
            this.isStart = isStart;
        }

    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null) {
            return s3 == null;
        } else if (s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2.length() == 0) {
            return s1.equals(s3);
        } else {
            int len1 = s1.length();
            int len2 = s2.length();
            int len3 = s3.length();
            if (len1 + len2 != len3) {
                return false;
            }
            boolean[][] dp = new boolean[len1+1][len2+1];
            dp[0][0] = true;
            for (int i = 1; i <= len1; i++) {
                dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1);
            }
            for (int i= 1; i <= len2; i++) {
                dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1);
            }
            for (int i = 1; i <= len1; i++) {
                char c1 = s1.charAt(i-1);
                for (int j = 1; j <= len2; j++) {
                    char c2 = s2.charAt(j-1);
                    char c3 = s3.charAt(i+j-1);
                    dp[i][j] = c1 == c3 && dp[i-1][j] || c2 == c3 && dp[i][j-1];
                }
            }
            return dp[len1][len2];
        }
    }

    //http://massivealgorithms.blogspot.com/2015/11/pocket-gems-ternary-expression-to.html
    //https://leetcode.com/discuss/66620/ternary-expression-to-binary-tree
    //https://jiangchengl.wordpress.com/2015/07/30/build-a-binary-tree-from-a-ternary-expression/
    public TreeNode buildTernaryTree(char[] expr) throws IllegalArgumentException{
        if (expr == null || expr.length < 5) {
            return null;
        }
        int len = expr.length;
        int i = len - 1;
        Stack<TreeNode> oprandStack = new Stack<TreeNode>();
        while(i >= 0) {
            char c = expr[i];
            if (c != '?' && c != ':') {
                oprandStack.push(new TreeNode(String.valueOf(c)));
                i--;
            } else if (c == '?') {
                char ch = expr[i-1];
                oprandStack.push(new TreeNode(String.valueOf(ch)));
                buildTreeNode(oprandStack);
                i-=2;
            } else if (c == ':') {
                i--;
            }
        }
        while(oprandStack.size() != 1) {
            buildTreeNode(oprandStack);
        }
        return oprandStack.pop();
    }
    private void buildTreeNode(Stack<TreeNode> oprandStack) throws IllegalArgumentException{
        if (oprandStack.size() < 3) {
            throw  new IllegalArgumentException();
        }
        TreeNode root = oprandStack.pop();
        TreeNode left = oprandStack.pop();
        TreeNode right = oprandStack.pop();
        root.left = left;
        root.right = right;
        oprandStack.push(root);

    }

    public TreeNode buildTernaryTreeII(char[] expr) {
        if (expr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(String.valueOf(expr[0]));

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < expr.length; i += 2) {
            TreeNode node = new TreeNode(String.valueOf(expr[i + 1]));

            if (expr[i] == '?') {
                stack.peek().left = node;
            }
            else if (expr[i] == ':') {
                stack.pop();
                while (stack.peek().right != null) {
                    stack.pop();
                }
                stack.peek().right = node;
            }

            stack.push(node);
        }

        return root;
    }
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                continue;
            }
            map.put(num, 1);
            if (map.containsKey(num-1)) {
                max = Math.max(max, merge(num-1, num, map));
            }
            if (map.containsKey(num+1)) {
                max = Math.max(max, merge(num, num + 1, map));
            }
        }
        return max;
    }
    public int merge(int left, int right, HashMap<Integer, Integer> map) {
        //
        int len1 = map.get(left);
        int len2 = map.get(right);
        //left - x + 1 = len1
        //y - right + 1 = len2
        int start = left + 1 - len1;
        int end = len2 - 1 + right;
        int len = end - start + 1;
        map.put(start, len);
        map.put(end, len);
        return len;
    }


    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean found = false;
        int i = 0;
        int start = 0;
        int len = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while ( i < len) {
            sum += nums[i];
            if (sum >= s) {
                found = true;
                while(start < len && sum - nums[start] >= s) {
                    sum -= nums[start];
                    start++;
                }
                //[start, i]
                min = Math.min(min, i - start + 1);
            }
            i++;
        }
        if (found) {
            return min;
        } else {
            return 0;
        }
    }

    public double evaluate(String exp, double x) {
        if (exp == null || exp.trim().length() == 0) {
            throw new IllegalArgumentException("empty exp");
        }
        int index = exp.indexOf('=');
        if (index == -1) {
            throw new IllegalArgumentException("invalid expression");
        }
        String left = exp.substring(0, index);
        String right = exp.substring(index+1);
        ArrayList<Double> leftExp = evaluateHelper(left, x);
        ArrayList<Double> rightExp = evaluateHelper(right, x);
        //A + By = C + Dy
        double a = leftExp.get(0);
        double b = leftExp.get(1);
        double c = rightExp.get(0);
        double d = rightExp.get(1);
        if (b == d) {
            throw new IllegalArgumentException("alway equal");
        }
        return (a-c)/(d-b);
    }

    public ArrayList<Double> evaluateHelper(String exp, double x) {
        //exp will be A + B*y
        //
        Stack<ArrayList<Double>> numStack = new Stack<ArrayList<Double>>();
        Stack<Character> opStack = new Stack<Character>();
        exp = exp.trim();
        int len = exp.length();
        int i = 0;
        while(i < len) {
            char c = exp.charAt(i);
            if (c == ' ') {
                i++;
            } else if (isOperator(c)) { //+ -  ( )
                if (c == ')') {
                    while(!opStack.isEmpty() && opStack.peek() != '(') {
                        compute(numStack, opStack);
                    }
                    opStack.pop();
                } else {
                    while(!opStack.isEmpty() && needCalculate(opStack.peek(), c)) {
                        compute(numStack, opStack);
                    }
                    opStack.push(c);
                }
                i++;
            } else {
                int j = i;
                while(j < len &&  (Character.isDigit(exp.charAt(j)) || exp.charAt(j) == '.')  ) {
                    j++;
                }
                //j point to non-digit
                //check if exp[j] is x or y
                if (j < len && exp.charAt(j) == 'x') {
                    //ax
                    double a = i == j ? 1.0 : Double.parseDouble(exp.substring(i,j));
                    a *= x;
                    //A + 0y
                    ArrayList<Double> num = new ArrayList<>();
                    num.add(a);
                    num.add(0.0);
                    numStack.push(num);
                    j++;
                } else if (j < len && exp.charAt(j) == 'y') {
                    double a = i == j ? 1.0 : Double.parseDouble(exp.substring(i,j));
                    //ay
                    //0 + ay
                    ArrayList<Double> num = new ArrayList<>();
                    num.add(0.0);
                    num.add(a);
                    numStack.push(num);
                    j++;
                } else {
                    String str = exp.substring(i, j);
                    double a = Double.parseDouble(str);
                    //A + 0y
                    ArrayList<Double> num = new ArrayList<>();
                    num.add(a);
                    num.add(0.0);
                    numStack.push(num);
                }
                i = j;
            }

        }

        while(!opStack.isEmpty()) {
            compute(numStack, opStack);
        }
        return numStack.pop();
    }



    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    public void computeII(Stack<Long> numStack, Stack<Character> opStack) {
        char op = opStack.pop();
        Long num2 = numStack.pop();
        Long num1 = numStack.pop();
        switch(op) {
            case '*':
                numStack.push(num1 * num2);
                break;
            case '+':
                numStack.push(num1 + num2);
                break;
            case '-':
                numStack.push(num1 - num2);
                break;
        }
    }



    public boolean isValidNum(String num) {
        if (num.charAt(0) == '0' && num.length() > 1) {
            return false;
        }
        return true;
    }

    public String alienOrder(String[] words)
    {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, ArrayList<Character>> adjacents = new HashMap<Character, ArrayList<Character>>();
        HashMap<Character, Integer> indegree = new HashMap<Character, Integer>();
        buildGraph(words, adjacents, indegree);
        StringBuffer sb = new StringBuffer();
        //0 - non visited,  or doesn't contains in the visited map
        //1 - visiting
        //2 visited
        HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
        for (int i =0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!visited.containsKey(c)) {
                    visited.put(c, 0);
                }
            }
        }
         /*
         Iterator<Character> iterator = visited.keySet().iterator();

         while(iterator.hasNext()) {
             char c = iterator.next();
             if (visited.get(c) == 0) {
                 if (!dfs(c, adjacents, visited,sb )) {
                     return "";
                 }
             }
         }
         return sb.toString(); */

        if (!bfs(adjacents, indegree, sb)) {
            return "";
        }
        return sb.toString();
    }



    public void buildGraph(String[] words, HashMap<Character, ArrayList<Character>> adjacents, HashMap<Character, Integer> indegree) {
        for (int  i =0 ; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!indegree.containsKey(c)) {
                    indegree.put(c, 0);
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {

            String one = words[i];
            String two = words[i+1];
            int j = 0;
            while(j < one.length() && j < two.length()) {
                if (one.charAt(j) != two.charAt(j)) {
                    char c = one.charAt(j);
                    char ch = two.charAt(j);
                    if (!adjacents.containsKey(c)) {
                        adjacents.put(c, new ArrayList<Character>());
                    }
                    adjacents.get(c).add(ch);

                    //increase the indegree fro two[j]
                    indegree.put(ch, indegree.get(ch) + 1);

                    break;
                }
                j++;
            }

        }
    }



    public boolean dfs(char u, HashMap<Character, ArrayList<Character>> adjacents, HashMap<Character, Integer> visited, StringBuffer order) {
        visited.put(u, 1);

        if (adjacents.containsKey(u)) {

            ArrayList<Character> neighbors = adjacents.get(u);
            for (int i =0; i < neighbors.size(); i++) {
                char v = neighbors.get(i);
                if ( visited.get(v) == 1) {
                    return false;
                } else if (visited.get(v) == 0 && !dfs(v, adjacents, visited, order)) {
                    return false;
                }
            }
        }
        visited.put(u, 2);
        order.insert(0, u);
        return true;
    }

    public boolean bfs(HashMap<Character, ArrayList<Character>> adjacents, HashMap<Character, Integer> indegree, StringBuffer order) {
        Deque<Character> deque = new ArrayDeque<Character>();
        Iterator<Character> iterator = indegree.keySet().iterator();
        while(iterator.hasNext()) {
            char c = iterator.next();
            if (indegree.get(c) == 0) {
                deque.addLast(c);
            }
        }
        while(!deque.isEmpty()) {
            char front = deque.pollFirst();
            order.append(front);
            if (adjacents.containsKey(front)) {
                ArrayList<Character> neighbors = adjacents.get(front);
                for (int i = 0; i < neighbors.size();i++) {
                    char v = neighbors.get(i);
                    indegree.put(v, indegree.get(v) - 1);
                    if (indegree.get(v) == 0) {
                        deque.addLast(v);
                    }
                }
            }
        }

        return order.length() == indegree.size();
    }

    public void printArray(int[] array) {
        for (int i =0; i < array.length; i++) {
            System.out.print(array[i] +" ,");
        }
    }
    /**
     * https://shawnlincoding.wordpress.com/2015/04/13/sort-array-given-order/
     * 第二题：给定两个array，一个是actual numbers, 另一个是position array, 按照position array将actual number array排序。
     例子：
     actual number array : [4 2 1 5 3].
     position array : [3 1 0 4 2];
     actual array => [1, 2, 3, 4, 5]
     inplace
     */
    public void restoreArray(int[] array, int[] position) {
        if (array == null || position == null || array.length != position.length) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            while(position[i] != i) {
                swap(array, i, position[i]);
                swap(position, i, position[i]);
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }



    public double parseFomularString(String s, double x) {
        //Parse a Formula String
        //http://www.fgdsb.com/2015/01/08/parse-formula/
        //5 + 2x – ( 3y + 2x - ( 7 – 2x) – 9 ) = 3 + 4y
        //A + B * Y
        //[A, B] or [A] only if on Y
         int index = s.indexOf("=");
         ArrayList<Double> left = parseFomularString_helper(s.substring(0, index), x);
         ArrayList<Double> right = parseFomularString_helper(s.substring(index+1), x);
        //A + B*Y = C + D *Y
        //Y = (C - A) / (B - D);
        return (right.get(0) - left.get(0)) / (left.get(1) - right.get(1));
    }



    public ArrayList<Double> parseFomularString_helper(String s, double x) {
        //return [A, B] means A + B* Y
        Stack<ArrayList<Double>> numStack = new Stack<ArrayList<Double>>();
        Stack<Character> opStack = new Stack<Character>();
        int len = s.length();
        int i = 0;
        while ( i < len) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '+' || c == '-') {
                while(!opStack.isEmpty() && needCalculate(opStack.peek(), c)) {
                    compute(numStack, opStack);
                }
                opStack.push(c);
                i++;
            } else if (c == '(') {
                opStack.push(c);
                i++;
            } else if (c == ')') {
                while(!opStack.isEmpty() && opStack.peek() != '(') {
                    compute(numStack, opStack);
                }
                opStack.pop(); //pop up (
                i++;
            } else {
                //number
                ArrayList<Double> num = new ArrayList<>();
                if (Character.isDigit(c)) {
                    int j = i;
                    while(j < len &&
                            (Character.isDigit(s.charAt(j)) ||  s.charAt(j) == 'x' || s.charAt(j) == 'y' ))
                    {
                        j++;
                    }
                    String str = s.substring(i, j);
                    if (str.endsWith("x")) {
                        num.add(Double.parseDouble(str.substring(0,str.length()-1)) * x);
                        num.add(0.0);
                    } else if (str.endsWith("y")) {
                        num.add(0.0);
                        num.add(Double.parseDouble(str.substring(0,str.length()-1)));
                    } else {
                        num.add(Double.parseDouble(str));
                        num.add(0.0);
                    }
                    numStack.push(num);
                    i = j;
                } else if (c == 'x') {
                    num.add(x);
                    num.add(0.0);
                    numStack.push(num);
                    i++;
                } else if (c == 'y') {
                    num.add(0.0);
                    num.add(1.0);
                    numStack.push(num);
                    i++;
                }
            }
        }
        while(!opStack.isEmpty()) {
            compute(numStack, opStack);
        }
        return numStack.pop();
    }

    public boolean needCalculate(char right, char left) {
        switch(right) {
            case '(':
                return false;
            case '+':
            case '-':
                return left == '+' || left == '-';
            default:
                return false;
        }
    }


    public void compute(Stack<ArrayList<Double>> numStack, Stack<Character> opStack) {
        ArrayList<Double> num2 = numStack.pop();
        ArrayList<Double> num1 = numStack.pop();
        char op = opStack.pop();
        ArrayList<Double> result = new ArrayList<>();
        switch(op) {
            case '+':
                result.add(num1.get(0) + num2.get(0));
                result.add(num1.get(1) + num2.get(1));
                break;
            case '-':
                result.add(num1.get(0) - num2.get(0));
                result.add(num1.get(1) - num2.get(1));

        }
        numStack.push(result);

    }

    public int getTime(String str, int cool) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int time = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (!map.containsKey(c) || map.get(c) <= time) {
                map.put(c, time + cool + 1);
                i++;
                time++;
            } else {
                time = map.get(c);
            }
        }
        return time;
    }
    public String taskRun(String tasks, int cooldown) {

        if (tasks == null || tasks.length() == 0 || cooldown <= 0) {
            return tasks;
        }
        StringBuffer sb = new StringBuffer();
        int timer = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //task, and earliest time to run this time
        while(i < tasks.length()) {
            char t = tasks.charAt(i);
            if (!map.containsKey(t) || map.get(t) <= timer ) {
                map.put(t, timer + cooldown + 1);
                //run task t
                sb.append(t);
                timer++;
                i++;
            } else {
                //we need run idle times
                int earliestTime = map.get(t);
                int idles = earliestTime - timer; //[timer, earliestTime-1] are all idle tasks
                for (int j = 0; j < idles; j++) {
                    sb.append("_");
                }
                timer += idles;
            }

        }
        return sb.toString();



    }
    public String taskRunII(String tasks, int cooldown) {
        StringBuffer sb = new StringBuffer();
        if (tasks == null || tasks.length() == 0 || cooldown <= 0) {
            return tasks;
        }
        //[char : nextTime]
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int time = 0;
        while (i < tasks.length()) {
            char c = tasks.charAt(i);
            if (!map.containsKey(c) || map.get(c) <= time) {
                sb.append(c);
                map.put(c, time + cooldown + 1); //earlies time can run c again
                time++;
                i++;
            } else {
                //
                int earliestTimeToRunTask = map.get(c);
                //[time, earliestTimeToRunTask - 1]  , need run idle tasks
                int idles = earliestTimeToRunTask - time;
                for (int j = 0; j < idles; j++) {
                    sb.append("_");
                }
                time = earliestTimeToRunTask;
            }
        }
        return sb.toString();
    }
    public String taskScheduler(String tasks, int cooldown) {
        //return "AB_AB_AB";

        if (cooldown <= 0 || tasks == null || tasks.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length();i++) {
            char t = tasks.charAt(i);
            if (!map.containsKey(t)) {
                map.put(t, 1);
            } else {
                map.put(t, map.get(t) + 1);
            }
        }

        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(map.size(), comparator);

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            maxHeap.offer(iterator.next());
        }

        while(!maxHeap.isEmpty()) {

            //try to get cooldown + 1 tasks,
            int n = Math.min(cooldown + 1, maxHeap.size());
            ArrayList<Map.Entry<Character, Integer>> front = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                front.add(maxHeap.poll());
            }

            for (int i = 0; i < n; i++) {
                Map.Entry<Character, Integer> entry = front.get(i);
                sb.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }
            if (!maxHeap.isEmpty()) {
                for (int i = n; i < cooldown + 1; i++) {
                    sb.append("_");
                }
            }

        }


        return sb.toString();
    }
    public String taskSchedulerII(String tasks, int cooldown) {
        //return "AB_AB_AB";

        if (cooldown <= 0 || tasks == null || tasks.length() == 0)  {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int len = tasks.length();
        for (int i =0; i < len; i++) {
            char task = tasks.charAt(i);
            if (map.containsKey(task)) {
                map.put(task, map.get(task) + 1);
            } else {
                map.put(task, 1);
            }
        }


        //used to create maxHeap
        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(map.size(), comparator);
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            maxHeap.offer(iterator.next());
        }
        StringBuffer sb = new StringBuffer();
        //every time we try to pop cooldown + 1 elements, to make sure we qualify the "cool down" for the first task
        while(!maxHeap.isEmpty()) {

            //try to pop up cooldown + 1 element
            int n = Math.min(maxHeap.size(), cooldown + 1);
            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
            for (int i =0; i < n; i++) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                temp.add(entry);
            }
            //output those tasks and decrease the frequency
            for(int i = 0; i < temp.size(); i++) {
                Map.Entry<Character, Integer> entry = temp.get(i);
                sb.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }
            int i = n;
            if (!maxHeap.isEmpty()) {
                while (i < cooldown + 1) {
                    sb.append("_");
                    i++;
                }
            }

        }

        return sb.toString();
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 4);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                //i = a + j* j;
                dp[i] = Math.min(dp[i], 1 + dp[i- j * j]);
            }
        }
        return dp[n];
    }

    public List<List<Integer>> findNumbers(int[] nums, int d) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i =0; i < size; i++) {
            int c = nums[i];
            int target = c + d;
            int left = 0;
            int right = size - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    ArrayList<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[left]);
                    oneResult.add(nums[right]);
                    oneResult.add(c);
                    Collections.sort(oneResult);
                    if (set.add(oneResult))
                    {
                        result.add(oneResult);
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;

    }
//
//    public List<List<Integer>> findNumbersII(int[] nums, int d) {
//
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if (nums == null || nums.length < 3) {
//            return result;
//        }
//        int size = nums.length;
//        //a+b-c = d
//        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
//        for (int i = 0; i < size;i++) {
//            if (!map.containsKey(nums[i] + d)) {
//                map.put(nums[i] +d, new HashSet<>());
//            }
//            map.get(nums[i]+d).add(i);
//        }
//
//        for (int i = 0; i < size; i++) {
//            for (int j = i+1; j < size; j++) {
//                int sum = nums[i] + nums[j];
//                if (map.containsKey(sum)) {
//                    HashSet<Integer> one = map.get(sum);
//                    if (!one.contains(i) && !one.contains(j)) {
//                        ArrayList<Integer> oneResult = new ArrayList<>();
//                        Iterator<Integer> iterator = one.iterator();
//                        while(iterator)
//                        oneResult.addAll(one);
//                        oneResult.add(i);
//                        oneResult.add(j);
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        char c = p.charAt(0);
        if (c == '*') {
            return isMatch(s, p.substring(1)) ||
                    s.length() > 0 && isMatch(s.substring(1), p);
        } else {
            return s.length() > 0 && (c == '?' || c == s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatchIII(String s, String p) {

        if (p == null || s == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        int i = 0;
        int len = s.length();
        int j = 0;
        int pLen = p.length();
        int pStar = -1;
        int sLast = -1;
        while(i < len) {

            if (j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if (j < pLen && p.charAt(j) == '*') {
                pStar = j;
                sLast = i;
                j++; //* match 0
            } else if (pStar >= 0) {
                j = pStar + 1;
                i = sLast+1;
                sLast++;
            } else {
                return false;
            }
        }
        while(j < pLen && p.charAt(j) == '*') j++;
        return j == pLen;


    }
    public boolean isMatchII(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            for (int i =0; i < p.length();i++) {
                if (p.charAt(i) != '*')
                {
                    return false;
                }
            }
            return true;
        }
        int pLen = p.length();
        int sLen = s.length();
        boolean[][] dp = new boolean[pLen+1][sLen+1];
        dp[0][0] = true;
        for (int i = 1; i <= sLen; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= pLen; i++) {
            dp[i][0] = dp[i-1][0] && p.charAt(i-1) == '*';
        }
        for (int i = 1; i <= pLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                char c = p.charAt(i-1);
                char ch = s.charAt(j-1);
                if (c == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = (c == '?' || c == ch) && dp[i-1][j-1];
                }
            }
        }
        return dp[pLen][sLen];

    }

    public List<List<Integer>> findSameContact(String[][] contacts) {
        List<List<Integer>> result = new ArrayList<>();
        if (contacts == null || contacts.length == 0 || contacts[0].length == 0) {
            return result;
        }
        int m = contacts.length;
        int[][] graph = buildGraph(contacts);
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {

                if ( !visited[i]) {
                    ArrayList<Integer> oneResult = new ArrayList<>();
                    dfs(i, graph, visited, oneResult);
                    result.add(oneResult);
                }
        }
        return result;
    }

    public void dfs(int u, int[][] graph, boolean[] visited, ArrayList<Integer> connected) {

        visited[u] = true;
        connected.add(u);
        for (int j = 0; j < graph[u].length; j++) {
            if (graph[u][j] == 1 && !visited[j]) {
                dfs(j, graph, visited, connected);
            }
        }

    }
    

    private int[][] buildGraph(String[][] contacts) {
        int m = contacts.length;
        int n = contacts[0].length;
        int[][] matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                //checkout if contacts[i] and contacts[j] has common field

                for (int k = 0; k < n; k++) {
                    for (int t = 0; t < n; t++) {
                        if (contacts[i][k].equals(contacts[j][t])) {
                            matrix[i][j] = 1;
                            matrix[j][i] = 1;
                        }
                    }
                }
//                for (int k = 0; k < n; k++) {
//                    new HashSet<String>(Arrays.asList(contacts[j])).contains(contacts[i][k]);
//                }
            }
        }
        return matrix;
    }

    public String revertWord(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i =0;
        int j = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        while(j < len) {
            while (j < len && s.charAt(j) != ' ') {
                j++;
            }
            swap(chars, i, j-1);
            i = ++j;

        }
        return new String(chars);
    }
    private void swap(char[] s, int i, int j) {
        while(i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }

//    public ArrayList<Integer> findTopKPair(int[] A, int[] B, int k) {
//
//    }
//
//    public ArrayList<Integer> findTopKPair_bf(int[] A, int[] B, int k) {
//
//    }

    public boolean findDominoPair(int[][] dominos) {

        HashSet<Integer> map = new HashSet<>();
        for (int i =0 ; i < dominos.length; i++) {
            int[] domino = dominos[i];
            int num = domino[0] * 10 + domino[1];
            int other = 66 - num;
            if (map.contains(other)){
                return true;
            }
            map.add(num);

        }
        return false;
    }
}
