import java.lang.reflect.Array;
import java.util.*;
import java.util.jar.Pack200;

/**
 * Created by shoulongli on 3/3/16.
 */
public class TestLeetcode {
    private enum Direction {UP_DOWN, DOWN_UP, LEFT_RIGHT, RIGHT_LEFT}

    ;

    public static void main(String[] argv) {

        int[] nums = new int[5];
        int[][] cache = new int[nums.length][nums.length];

        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        //int[] input = {-1, 2, 0};
        //int[] input = {5,2,4,1,3,6,0};
        print(input);
        TestLeetcode test = new TestLeetcode();
        test.quicksort(input);
        print(input);
//        test.mergesort(input, 0, input.length-1);
        test.quicksortII(input, 0, input.length - 1);
        print(input);
        //quicksortII(input, 0, input.length -1);
        //quicksort(input);
        //print(input);
//        System.out.println(test.findMedianSortedArrays(new int[]{1,2}, new int[] {1,2}));
//        System.out.println(test.canPermutePalindrome("as"));
//        System.out.println(test.bfs("()(((((((()"));
//        TreeNode node1 = new TreeNode(1);
//        node1.left = new TreeNode(2);
//        System.out.println(test.pathSum(node1, 3));
        //System.out.println(test.removeInvalidParentheses("()(((((((()"));

        String[][] tickets2 = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        System.out.println(test.findItinerary(tickets));

        int[][] nums2 = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};
        System.out.println(test.longestIncreasingPath(nums2));

        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(test.findMinHeightTrees(6, edges));

        TreeNode t1 = new TreeNode(1);
        System.out.println(test.countNodes(t1));

        int[][] b1 = {{1, 1}, {0, 1}};
        /*
        1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
         */
        int[][] b2 = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        //System.out.println(test.shortestDistance(b1));
        System.out.println(test.shortestDistance(b2));

        TreeNode i1 = new TreeNode(1);
        i1.left = new TreeNode(2);
        i1.left.left = new TreeNode(3);
        i1.left.left.left = new TreeNode(4);
        i1.left.left.left.left = new TreeNode(5);


        System.out.println(test.ramanujan(30));
        System.out.println(test.ramanujanII(30));

        System.out.println(5 + (4 > 0 ? 1 : -1));

        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(test.wordBreak(s, dict));
        System.out.println(test.wordBreakI(s, dict));
        System.out.println(test.wordBreakII(s, dict));
        System.out.println(test.minCut("aab"));

        //System.out.println(test.removeInvalidParentheses("v)z())((("));
        System.out.println(test.partition("aab"));

        boolean[][] b = test.getIsPalindromeII("aaaabaaa");
        System.out.println(test.minCut("aab"));
        System.out.println(test.longestPalindromeI("aaaabaaa"));
        int[] nums3 = {1, 1, 1, 2, 2, 3};
        System.out.println(test.topKFrequent(nums3, 2));

        System.out.println(test.shortestPalindrome("aabba"));
        System.out.println(test.shortestPalindromeII("aabba"));

        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        System.out.println(test.encode(strings));
        System.out.println(test.decode(test.encode(strings)));
        System.out.println(test.calculateII("1*2-3/4+5*6-7*8+9/10"));
        //3+5 / 2
        System.out.println(test.calculate("(1+(4+5+  2 )-3)+(6+8)"));
        System.out.println(test.diffWaysToCompute("0+1"));

        System.out.println(test.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));

        System.out.println(test.totalNQueens(2));
        System.out.println(test.kSumII(new int[] {1,2,3,4}, 2, 5));

        System.out.println(test.coinChange(new int[]{1,2,5}, 11));
    }

    class UnionFind {
        private HashMap<Integer, Integer> parent ;
        private HashSet<Integer> roots;
        private HashMap<Integer, Integer> rank;
        public UnionFind() {
            parent = new HashMap<Integer, Integer>();
            roots = new HashSet<Integer>();
            rank = new HashMap<Integer, Integer>();
        }
        public int getRootSize() {
            return roots.size();
        }
        public boolean contains(int num) {
            return parent.containsKey(num);
        }
        public void add(int num) {
            if (parent.containsKey(num)) {
                return;
            }
            parent.put(num, num);
            rank.put(num, 1);
            roots.add(num);
        }
        public int find(int num) {
            if(parent.get(num) == num) {
                return num;
            }
            return find(parent.get(num));
        }
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            int rankA = rank.get(a);
            int rankB = rank.get(b);
            if (rankA < rankB) {
                parent.put(a, b);
                roots.remove(a);
            } else if (rankB < rankA) {
                parent.put(b, a);
                roots.remove(b);
            } else {
                parent.put(a, b);
                rank.put(b, rank.get(b) + 1);
                roots.remove(a);
            }
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        if (m <= 0 || n <= 0 || positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }
        UnionFind uf = new UnionFind();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int len = positions.length;
        for (int i = 0; i < len; i++) {
            int[] position = positions[i];
            int index = position[0] * n + position[1];
            uf.add(index);
            for (int j = 0; j < dirs.length; j++) {
                int nextX = position[0] + dirs[j][0];
                int nextY = position[1] + dirs[j][1];
                int nextIndex = nextX * n + nextY;
                if (uf.contains(nextIndex)) {
                    uf.union(index, nextIndex);
                }
            }
            result.add(uf.getRootSize());
        }
        return result;
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(1, n, k, result, new ArrayList<Integer>(), 0);
        return result;
    }

    public void helper(int start, int k, int n, List<List<Integer>> result,  List<Integer> oneResult, int remaining) {
        if (remaining == 0) {
            if (oneResult.size() == k) {
                result.add(new ArrayList<Integer>(oneResult));
            }
        } else if (remaining > 0 && start < 9) {
            oneResult.add(start);
            helper(start+1, k, n, result, oneResult, remaining - start);
            oneResult.remove(oneResult.size() - 1);
        }
    }
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0 ) {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //get k coins[i-1]
                for (int k = 0; k * coins[i-1] <= j; k++) {

                    if (dp[i-1][j-k*coins[i-1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k*coins[i-1]] + k);
                    }
                }
            }
        }
        return dp[n][amount];
    }

    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        //helper(res, path, A, k, target, 0);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            nums.add(A[i]);
        }
        return helper(nums, k, target);
    }

    public ArrayList<ArrayList<Integer>>  helper(ArrayList<Integer> nums, int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (k == 0 && target == 0) {
            ArrayList<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            return result;
        } else {
            HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
            for (int i = 0; i < nums.size(); i++) {
                int num = nums.get(i);
                nums.remove(i);
                ArrayList<ArrayList<Integer>> result1 = helper(nums, k-1, target - num);
                for (int j = 0; j < result1.size(); j++) {
                    ArrayList<Integer> one = result1.get(j);
                    one.add(num);
                    Collections.sort(one);
                    if (set.add(one)) {
                        result.add(one);
                    }
                }

                ArrayList<ArrayList<Integer>> result2 = helper(nums, k, target);
                for (int j = 0; j < result2.size(); j++) {
                    ArrayList<Integer> one = result2.get(j);
                    Collections.sort(one);
                    if (set.add(one)) {
                        result.add(one);
                    }
                }
                nums.add(i, num);
            }
        }
        return result;
    }
    private int count = 0;
    public int totalNQueens(int n) {
        //write your code here
        if (n < 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            count = 0;
            tryPlace(n,queens,  0);
            return count;
        }
    }

    public void tryPlace(int n, int[] queens, int row) {
        if (row == n) {
            count++;
            return;
        } else if (row < n) {
            for (int i = 0; i < n; i++) {
                if (isValid(queens, row, i)) {
                    queens[row] = i;
                    tryPlace(n, queens, row+1);
                    queens[row] = -1;
                }
            }
        }
    }

    public boolean isValid(int[] queens, int row, int trial) {
        for (int i = 0; i < row; i++) {
            //(i, queens[i])  (row, trial)
            if (queens[i] == trial ||
                    trial - queens[i] == row - i ||
                    trial - queens[i] == i - row
                    ) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        return combinationSum2_helper(candidates, target, 0, candidates.length - 1);
    }

    public List<List<Integer>> combinationSum2_helper(int[] candidates, int target, int start, int end) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0) {
            ArrayList<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            return result;
        } else if (start > end) {
            return result;
        } else if (target > 0) {
            int first = candidates[start];
            List<List<Integer>> excludeFirst = combinationSum2_helper(candidates, target, start+1, end);
            List<List<Integer>> includeFirst = combinationSum2_helper(candidates, target - first, start+1, end);
            HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
            for (int i = 0; i < excludeFirst.size();i++) {
                ArrayList<Integer> one = (ArrayList<Integer>)(excludeFirst.get(i));
                if (set.add(one)) {
                    result.add(one);
                }
            }
            for (int i = 0; i < includeFirst.size();i++) {
                ArrayList<Integer> one = (ArrayList<Integer>)(includeFirst.get(i));
                one.add(0, first);
                if (set.add(one)) {
                    result.add(one);
                }
            }
        }
        return result;


    }

    public int calculateII(String s) {
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

    public int calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        s = s.trim();
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();
        int len = s.length();
        int i = 0;
        while (i < len) {

            //parse
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //get the number
                int j = i;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                //j now point to the first non digit num
                String str = s.substring(i, j);
                numStack.push(Integer.parseInt(str));
                i = j;
            } else if (c == ' ') {
                i++;
            } else {
                if (c == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        compute(opStack, numStack);
                    }
                    opStack.pop();
                } else {
                    while (!opStack.isEmpty() && needCalculate(opStack.peek(), c)) {
                        compute(opStack, numStack);
                    }
                    opStack.push(c);
                }
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
                numStack.push(num1%num2);
                break;
            default:
                break;
        }
    }
    public String shortestPalindromeII(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int[] failure = next(s);
        //longest comment prefix is failure[str.length]
        int commonLen = failure[failure.length - 1];
        if (commonLen >= s.length()) {
            return s;
        }
        String postfix = s.substring(commonLen);

        return reverse(postfix) + s;

    }
    public int[] next(String str) {
        String s = str + "#"+reverse(str);
        int[] next = new int[s.length()+1];
        next[0] = -1;
        //next[i-1] = j;
        int j = -1;
        int i = 1;
        while(i <= s.length()) {
            if (j == -1 || s.charAt(i-1) == s.charAt(j)) {
                next[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = next[j];
            } else {
                next[i] = 0;
                i++;
            }
        }
        for (int k = 0; k < next.length; k++) {
            System.out.print(next[k]+ ",");
        }
        System.out.println();
        return next;
    }
    public String shortestPalindrome(String s) {
        int j = 0;

        for (int i = s.length() - 1; i >= 0; i--) {//找到第一个使他不回文的位置
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }

        if (j == s.length()) {  //本身是回文
            return s;
        }

        String suffix = s.substring(j); // 后缀不能够匹配的字符串
        String prefix = new StringBuilder(suffix).reverse().toString(); // 前面补充prefix让他和suffix回文匹配
        String mid = shortestPalindrome(s.substring(0, j)); //递归调用找 [0,j]要最少可以补充多少个字符让他回文
        String ans = prefix + mid + suffix;
        return ans;
    }
    public String shortestPalindromeI(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int len = s.length();
        if (isPalindrome(s)) {
            return s;
        }
        for (int i = 0; i < len; i++ ) {
            int[] range = expand(s, i, i);
            if (range[1] - range[0] + 1 > max) {
                max = range[1] - range[0] + 1;
                maxStart = range[0];
                maxEnd = range[1];
            }
            if (i + 1 < len && s.charAt(i) == s.charAt(i+1)) {
                range = expand(s, i,i+1);
                if (range[1] - range[0] + 1 > max) {
                    max = range[1] - range[0] + 1;
                    maxStart = range[0];
                    maxEnd = range[1];
                }
            }
        }
        //[maxStart, maxEnd] is longest parlindrome
        StringBuffer sb = new StringBuffer();
        String prefix = s.substring(0, maxStart);
        String postfix = s.substring(maxEnd+1);
        sb.append(reverse(postfix));
        sb.append(prefix);
        sb.append(s.substring(maxStart, maxEnd+1));
        sb.append(reverse(prefix));
        sb.append(postfix);
        return sb.toString();
    }
    //s.charAt(left) == s.charAt(right)
    //we continue to expand
    public int[] expand(String s, int left, int right) {
        while(left >=0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left+1, right - 1};
    }

    public String longestPalindromeI(String s) {
        if (s == null ) {
            return null;
        } else if (s.length() == 0) {
            return "";
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len -1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
        for (int i = len -3; i>=0; i--) {

            for (int j = i + 2; j < len; j++) {

                if ( dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }


    public List<Integer> findMinHeightTreesII(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 0) {
            return result;
        }

        HashMap<Integer, HashSet<Integer>> adjacents = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!adjacents.containsKey(edge[0])) {
                adjacents.put(edge[0], new HashSet<Integer>());
            }
            adjacents.get(edge[0]).add(edge[1]);
            if(!adjacents.containsKey(edge[1])) {
                adjacents.put(edge[1], new HashSet<Integer>());
            }
            adjacents.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();
        Iterator<Integer> iterator = adjacents.keySet().iterator();
        while(iterator.hasNext()) {
            int u = iterator.next();
            if (adjacents.get(u).size() == 1) {
                queue.addLast(u);
            }
        }
        while(queue.size() > 2) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int u = queue.pollFirst();
                int v = adjacents.get(u).iterator().next();
                adjacents.get(v).remove(u);
                if (adjacents.get(v).size() == 1) {
                    queue.addLast(v);
                }
            }
        }
        return new ArrayList<Integer>(queue);
    }
    public boolean[][] getIsPalindromeII(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len -1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }

        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
        for (int i = len -3; i>=0; i--) {

            for (int j = i + 2; j < len; j++) {

                if ( dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }



    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 0;
        boolean[][] isPalindrome = getIsPalindrome(s);
        for (int  i = 1; i <= len; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {

                if (isPalindrome[j][i-1]) {
                    min = Math.min(min,  1 + dp[j]);
                }
            }
            dp[i] = min;
        }
        return dp[len] - 1;
    }

    public boolean[][] getIsPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len -1; i++) {
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1) );
        }

        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        tryCut(s, 0, result, new ArrayList<String>());
        return result;
    }

    public void tryCut(String s, int index, List<List<String>> result, ArrayList<String> current) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        } else if (index < s.length()) {
            for (int i = 1; i <= s.length() - index; i++) {
                String str = s.substring(index, index+i);
                if (isValidPalindrome(str)) {
                    current.add(str);
                    tryCut(s, index+i, result, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return dfs(s, wordDict, map);

    }
    public ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int len = s.length();
        ArrayList<String> result = new ArrayList<String>();
        if (len <= 0) {
            return result;
        }
        for (int i = 1; i <= len; i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == len) {
                    result.add(prefix);
                } else {
                    String postfix = s.substring(i);

                    ArrayList<String> n_1 = dfs(postfix, dict, map);
                    for (int j = 0; j < n_1.size(); j++) {
                        result.add(prefix + " " + n_1.get(j));
                    }
                }
            }

        }
        map.put(s, result);
        return result;
    }
    public List<String> wordBreakII(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        int len = s.length();
        Result[] dp = new Result[len+1];
        ArrayList<String> empty = new ArrayList<String>();
        empty.add("");
        dp[0] = new Result(true, empty);
        for (int i = 1; i <= len; i++) {

            dp[i] = new Result(false, new ArrayList<String>());
            for (int j = i-1; j >= 0; j--) {
                String str = s.substring(j, i);
                if (wordDict.contains(str) && dp[j].canBreak ) {
                    dp[i].canBreak = true;
                    for(int k = 0; k < dp[j].result.size(); k++) {
                        String oneResult = dp[j].result.get(k);
                        StringBuffer sb = new StringBuffer(oneResult);
                        if (sb.length() > 0) {
                            sb.append(" ");
                        }
                        sb.append(str);
                        dp[i].result.add(sb.toString());

                    }
                }
            }
        }
        return dp[len].result;
    }
    class Result {
        boolean canBreak;
        ArrayList<String> result ;
        public Result() {
            canBreak = false;

        }
        public Result(boolean canBreak, ArrayList<String> result) {
            this.canBreak = canBreak;
            this.result = result;
        }
    }
    public List<String> wordBreakI(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        tryBreak(s, 0, wordDict, result, new ArrayList<String>());
        return result;
    }

    public void tryBreak(String s, int index, Set<String> dict, List<String> result, ArrayList<String> current) {
        if (index == s.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < current.size();i++) {
                sb.append(current.get(i));
                if (i < current.size() - 1) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
            return;
        } else if (index < s.length()) {
            for (int i = s.length() - index; i >= 1; i--) {
                String str = s.substring(index, index+i);
                if (dict.contains(str)) {
                    current.add(str);
                    tryBreak(s, index+i, dict, result, current);
                    current.remove(current.size()-1);
                }
            }
        }
    }

    private String reverse(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] array = s.toCharArray();
        int lo = 0;
        int hi = array.length - 1;
        while (lo < hi) {
            char temp = array[lo];
            array[lo] = array[hi];
            array[hi] = temp;

            lo++;
            hi--;
        }

        return new String(array);
    }


    public List<List<Integer>> ramanujan(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0) {
            return result;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = i*i*i + j*j*j;
                if (map.containsKey(sum)) {
                    ArrayList<Integer> left = map.get(sum);
                    ArrayList<Integer> oneResult = new ArrayList<>();
                    oneResult.add(left.get(0));
                    oneResult.add(left.get(1));
                    oneResult.add(i);
                    oneResult.add(j);
                    result.add(oneResult);
                } else {
                    ArrayList<Integer> sumValue = new ArrayList<Integer>();
                    sumValue.add(i);
                    sumValue.add(j);
                    map.put(sum, sumValue);
                }
            }
        }
        return result;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if (lh == rh) {
            return (1 << lh) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right);
        }


    }
    public int getLeftHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    public int getRightHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.right;
        }
        return height;
    }

    public List<List<Integer>> ramanujanII(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0) {
            return result;
        }

        for (int a = 1; a < n; a++) {
            long a3 = a * a * a;
            for (int b = a + 1; b < n; b++) {
                long b3 = b * b * b;
                for (int c = a+1; c < n; c++) {
                    long c3 = c * c * c;
                    for (int d = c + 1; d < n; d++) {
                        long d3 = d * d * d;
                        if (a3 + b3 == c3 + d3) {
                            ArrayList<Integer> oneResult = new ArrayList<>();
                            oneResult.add(a);
                            oneResult.add(b);
                            oneResult.add(c);
                            oneResult.add(d);
                            result.add(oneResult);
                        }
                    }
                }
            }
        }
        return result;
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int len = 0;
        Deque<String> queue = new ArrayDeque<String>();
        queue.addLast(s);
        HashSet<String> set = new HashSet<String>();
        set.add(s);
        while(!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.pollFirst();

                if (isValidII(str) && str.length() >= len) {
                    len = str.length();
                    result.add(str);
                } else if (str.length() > len) {
                    for (int j = 0; j < str.length();j++) {

                        char c = str.charAt(j);
                        if (c != '(' && c != ')') {
                            continue;
                        }
                        String next = str.substring(0,j) + str.substring(j+1);
                        if(set.add(next)) {
                            queue.addLast(next);
                        }
                    }
                }
            }
        }
        return result;
    }

    
    private boolean isValidII(String s) {
        if (s == null ) {
            return false;
        }

        int left = 0;
        int right = 0;
        for (int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
                if (right > left) {
                    return false;
                }
            }

        }
        return left == right;
    }



    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i1 == i2) {
                    return 0;
                }
                double delta = Math.abs(i1 - target) - Math.abs(i2 - target);
                if (delta < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        return result;
    }




    public boolean isValidP(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i =0;
        int j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }






    public boolean isValidPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i =0;
        int j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }



    public String alienOrder(String[] words)
    {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, ArrayList<Character>> adjacents = new HashMap<Character, ArrayList<Character>>();
        HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
        buildGraphAndState(words, adjacents, visited);
        StringBuffer sb = new StringBuffer();
        Iterator<Character> iterator = visited.keySet().iterator();
        while(iterator.hasNext()) {
            char c = iterator.next();
            if (visited.get(c) == 0) {
                if (dfs(c, adjacents, visited, sb)) {
                    return "";
                }
            }
        }
        return sb.toString();
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == end) {
            return 0;
        }
        dict.add(start);
        dict.add(end);
        Deque<String> queue = new ArrayDeque<String>();
        HashSet<String> used = new HashSet<String>();
        queue.addLast(start);
        used.add(start);
        int level = 0;
        while(!queue.isEmpty()) {
            //get the size of the queue, it is the size of the current level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String front = queue.pollFirst();
                ArrayList<String> neighbors = getNeighbors(front, dict);
                for (int j = 0; j < neighbors.size(); j++) {

                    String str = neighbors.get(j);
                    if (str.equals(end)) {
                        return level + 1;
                    }
                    if(!used.contains(str)) {
                        used.add(str);
                        queue.addLast(str);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public ArrayList<String> getNeighbors(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (ch == c) {
                    continue;
                }
                StringBuffer sb = new StringBuffer(s);
                sb.setCharAt(i, c);
                String word = sb.toString();
                if (dict.contains(word)) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    private void buildGraphAndState(String[] words, HashMap<Character, ArrayList<Character>> adjacents,  HashMap<Character, Integer> state) {

        int size = words.length;
        for (int i = 0; i < size; i++ ) {
            String s = words[i];
            for (int j = 0; j < s.length();j++) {
                char c = s.charAt(j);
                if (!state.containsKey(c)) {
                    state.put(c, 0);
                }
            }
        }


        for (int i =0; i < size - 1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            int j = 0;
            while(j < s1.length() && j < s2.length()) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    char c1 = s1.charAt(j);
                    char c2 = s2.charAt(j);
                    if (!adjacents.containsKey(c1)) {
                        adjacents.put(c1, new ArrayList<Character>());
                    }
                    adjacents.get(c1).add(c2);
                    break;
                }
                j++;
            }
        }
    }

    private boolean dfs(char u, HashMap<Character, ArrayList<Character>> adjacents , HashMap<Character, Integer> visited, StringBuffer sb) {
        visited.put(u, 1);// 1 means visiting

        if (adjacents.containsKey(u)) {
            ArrayList<Character> neighbors = adjacents.get(u);
            for (int i = 0; i < neighbors.size(); i++) {
                char v = neighbors.get(i);
                if (visited.get(v) == 1) {
                    return false;
                } else if (visited.get(v) == 0 && !dfs(v, adjacents, visited, sb)) {
                    return false;
                }
            }
        }

        sb.insert(0, u);
        visited.put(u, 2);
        return true;
    }
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        int sum = 0;
        int i = 0;
        boolean found =false;
        int start = 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        while (i < len) {
            sum += nums[i];
            if (sum >= s)  {
                found = true;
                //[start, i ] >= s
                while(start < len && sum - nums[start] >= s ) {
                    sum -= nums[start];
                    start++;
                }
                //start, i
                min = Math.min(min, i - start + 1);
            }
            i++;
        }
        return found? min : 0;
    }

    public void mergesort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end)/2;
        mergesort(nums, start, middle);
        mergesort(nums, middle + 1, end);
        int i = start;
        int j = middle + 1;
        //merge
        while(i <= middle && j < end) {
            if (nums[i] <= nums[j]) {
                i++;
            } else {
                //nums[i] > nums[j]
                //move [i, j-1] to [i+1, j]
                int temp = nums[j];
                System.arraycopy(nums, i, nums,i+1, j-i);
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }

    public void quicksortII(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int i = start;
        int j = end;
        while(i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else if (nums[j] > pivot) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        //j point to <= pivot
        //i point to > pivot and i = j+1
        swap(nums, start, j);
        quicksortII(nums, start, j-1);
        quicksortII(nums, j+1, end);

    }



    public String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null ) {
            return result;
        } else if (digits.length() == 0) {
            return result;
        } else if (digits.length() == 1) {
            return mappingOneChar(digits.charAt(0));
        }
        char first = digits.charAt(0);
        List<String> digit = mappingOneChar(first);
        List<String> result_n_1 = letterCombinations(digits.substring(1));
        for (int i = 0; i < result_n_1.size(); i++) {
            for (int j = 0; j < digit.size();j++) {
                result.add(digit.get(j)+result_n_1.get(i));
            }
        }
        return result;
    }

    public List<String> mappingOneChar(char c) {
        List<String> result = new ArrayList<String>();
        String r = "";
        if (c >= '0' && c <= '9') {
            r = mapping[c-'0'];
        }
        for (int i = 0; i < r.length();i++) {
            result.add(r.charAt(i)+"");
        }
        return result;
    }







    private void bfs(char[][] board, int row, int column) {

        Deque<Integer> queue = new ArrayDeque<Integer>();
        int m = board.length;
        int n = board[0].length;
        queue.addLast(row * n + column);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        board[row][column] = '#';
        while(!queue.isEmpty()) {

            int cur = queue.pollFirst();
            int r = cur / n;
            int c = cur % n;

            for (int i = 0; i < dirs.length; i++) {
                int nextR = r + dirs[i][0];
                int nextC = c + dirs[i][1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && board[nextR][nextC] == 'O') {
                    bfs(board, nextR, nextC);
                }
            }
        }
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] reached = new int[m][n]; //reach[i][j] means how many house can reach it
        int[][] dist = new int[m][n]; //dist[i][j] means the total distance

        int buildingNum = 0;
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    buildingNum++;
                    boolean[][] visited = new boolean[m][n];
                    bfs(grid, i, j, visited, dist, reached);
                }
            }
        }


        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++ ) {
                if (grid[i][j] == 0 && reached[i][j] == buildingNum) {
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;

    }

    public void bfs(int[][] grid, int row, int column, boolean[][] visited, int[][] dist, int[][] reached) {
        visited[row][column] = true;

        Deque<Integer> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        queue.addLast(row * n + column);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int level = 0;
        while (!queue.isEmpty()) {
            //handle this level
            int size = queue.size();
            for (int i = 0; i < size;i++) {
                int cur = queue.pollFirst();
                int r = cur / n;
                int c = cur % n;
                for (int j = 0; j < dirs.length;j++) {
                    int nextR = r + dirs[j][0];
                    int nextC = c + dirs[j][1];
                    if (nextR >= 0 && nextR < m &&
                            nextC >= 0 && nextC < n &&
                            grid[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        reached[nextR][nextC]++;
                        dist[nextR][nextC] += level + 1;
                        queue.addLast(nextR * n + nextC);
                    }
                }
            }
            level++;
        }

    }

    public int countNodesII(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftDepth = 0;
            TreeNode p = root;
            while (p != null) {
                p = p.left;
                leftDepth++;
            }
            int rightDepth = 0;
            p = root;
            while (p != null) {
                p = p.right;
                rightDepth++;
            }
            if (leftDepth == rightDepth) {
                return (2 << leftDepth) - 1;
            } else {
                return countNodesII(root.left) + countNodesII(root.right) + 1;
            }
        }
    }



    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> leaves = new ArrayList<Integer>();
        HashMap<Integer, HashSet<Integer>> adjacents = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!adjacents.containsKey(edge[0])) {
                adjacents.put(edge[0], new HashSet<>());
            }
            adjacents.get(edge[0]).add(edge[1]);
            if (!adjacents.containsKey(edge[1])) {
                adjacents.put(edge[1], new HashSet<>());
            }
            adjacents.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            if (adjacents.containsKey(i) && adjacents.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i = 0; i < leaves.size(); i++) {
                int leaf = leaves.get(i);
                //leaf now has only one neighbor
                int neighbor = adjacents.get(leaf).iterator().next();
                adjacents.get(neighbor).remove(leaf);
                if (adjacents.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;

        }
        return leaves;
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if (!isAlphanumberic(s.charAt(i))) {
                i++;
            } else if (!isAlphanumberic(s.charAt(j))) {
                j--;
            } else if (Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(j))) {
                i++;
                j--;

            } else {
                return false;
            }

        }
        return true;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return entry1.getValue() - entry2.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>> (k, comparator);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator2 = minHeap.iterator();
        while(iterator2.hasNext()) {
            result.add(0, iterator2.next().getKey());
        }
        return result;
    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int life = board[i][j];
                int neighborLives = getNumOfLives(board, i, j);
                if (life == 1) {
                    if (neighborLives < 2 || neighborLives > 3) {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                } else if (life == 0) {
                    if (neighborLives == 3) {
                        next[i][j] = 1;
                    } else {
                        next[i][j] = 0;
                    }
                }
            }
        }
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

    public int getNumOfLives(int[][] board, int row, int column) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int m = board.length;
        int n = board[0].length;
        int lives = 0;
        for (int i = 0; i < dirs.length; i++) {
            int r = row + dirs[i][0];
            int c = column + dirs[i][1];
            if (r >= 0 &&
                    r < m &&
                    c >= 0 &&
                    c < n &&
                    board[r][c] == 1) {
                lives++;
            }
        }
        return lives;
    }


    public boolean isAlphanumberic(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache);
                if (len > max) {
                    max = len;
                }
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] cache) {

        if (cache[row][column] > 0) {
            return cache[row][column];
        }
        int max = 1;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; //up, down, left, right
        for (int i = 0; i < dirs.length; i++) {
            int r = row + dirs[i][0];
            int c = column + dirs[i][1];
            if (r >= 0 &&
                    r < matrix.length &&
                    c >= 0 &&
                    c < matrix[0].length &&
                    matrix[r][c] > matrix[row][column] ) {
                int len = 1 + dfs(matrix, r, c, cache);
                if (len > max) {
                    max = len;
                }
            }
        }
        cache[row][column] = max;
        return max;
    }

    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }

        HashMap<String, PriorityQueue<String>> outDegree = new HashMap<String, PriorityQueue<String>>();
        HashMap<String, PriorityQueue<String>> inDegree = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String from = ticket[0];
            String to = ticket[1];
            if (!outDegree.containsKey(from)) {
                outDegree.put(from, new PriorityQueue<>());
            }
            outDegree.get(from).offer(to);

            if (!inDegree.containsKey(to)) {
                inDegree.put(to, new PriorityQueue<>());
            }
            inDegree.get(to).offer(from);
        }
        String start = null;
        String end = null;
        for (int i =0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String from = ticket[0];
            String to = ticket[1];

            int outFrom = outDegree.containsKey(from) ? outDegree.get(from).size() : 0;
            int outTo = outDegree.containsKey(to) ? outDegree.get(to).size() : 0;

            int inFrom = inDegree.containsKey(from) ? inDegree.get(from).size() : 0;
            int inTo = inDegree.containsKey(to) ? inDegree.get(to).size() : 0;
            System.out.println(from+ " out: "+outFrom+" in: "+inFrom);
            System.out.println(to+ " out: "+outTo+" in: "+inTo);
            if (outFrom == inFrom + 1) {
                if (start == null) {
                    start = from;
                }

            } else if (outFrom == inFrom - 1) {
                if (end == null) {
                    end = from;
                }
            }
            if (outTo == inTo + 1 ) {
                if (start == null) {
                    start = to;
                }

            } else if (outTo == inTo - 1) {
                if (end == null) {
                    end = to;
                }

            }


        }

        dfs(start, outDegree, result);
        return result;
    }

    public void dfs(String u, HashMap<String, PriorityQueue<String>> adjacents, List<String> routes) {

        if (adjacents.containsKey(u)) {
            PriorityQueue<String> neighbors = adjacents.get(u);
            System.out.println(neighbors);

            int size = adjacents.get(u).size();
            for(int i = 0; i < size; i++)
            //while(adjacents.get(u).size() > 0)
            {
                //similar to remove one in degree
                dfs(neighbors.poll(), adjacents, routes);
            }
        }
        routes.add(0, u);
    }

    private static final char SPECIAL_CHAR = '#';
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (int i =0 ;i < strs.size(); i++) {
            String str = strs.get(i);
            sb.append(str.length()).append(SPECIAL_CHAR).append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int len = s.length();
        int i = 0;
        List<String> result = new ArrayList<String>();
        while(i < len) {
            int index = s.indexOf("#", i);
            int length = Integer.parseInt(s.substring(i, index));
            String str = s.substring(index+1, index+1+length);
            i = index+1;
            result.add(str);
        }
        return result;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

        int n = words.length;
        int len = words[0].length();
        HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
        for (int i =0; i < n; i++) {
            String word = words[i];
            if (!needToFind.containsKey(word)) {
                needToFind.put(word, 1);
            } else {
                needToFind.put(word, needToFind.get(word) + 1);
            }
        }
        int size = n * len;
        HashMap<String, Integer> found  = new HashMap<String, Integer>();
        for (int i = 0; i + size <= s.length(); i++) {

            boolean flag = true;
            for (int j = 0; j < n; j++) {
                String str = s.substring(i * len, i*len + len);
                if (!found.containsKey(str)) {
                    found.put(str, 1);
                } else {
                    found.put(str, found.get(str) + 1);
                }
                if (!needToFind.containsKey(str) || found.get(str) > needToFind.get(str)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
            found.clear();
        }
        return result;
    }
    private boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        for (int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
                if (right > left) {
                    return false;
                }
            }

        }
        return left == right;
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        } else if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ArrayList<Integer> oneResult = new ArrayList<Integer>();
                oneResult.add(sum);
                result.add(oneResult);
            }

        } else if (root.left == null) {
            List<List<Integer>> right = pathSum(root.right, sum - root.val);
            if (right != null && right.size() > 0) {
                for (int i = 0; i < right.size();i++) {
                    ArrayList<Integer> one = (ArrayList<Integer>)right.get(i);
                    one.add(0, root.val);
                }
            }
        } else if (root.right == null) {
            List<List<Integer>> left = pathSum(root.left, sum - root.val);
            if (left != null && left.size() > 0) {
                for (int i = 0; i < left.size();i++) {
                    ArrayList<Integer> one = (ArrayList<Integer>)left.get(i);
                    one.add(0, root.val);
                    result.add(one);
                }
            }
        } else {
            List<List<Integer>> left = pathSum(root.left, sum - root.val);
            List<List<Integer>> right = pathSum(root.right, sum - root.val);
            if (left != null && left.size() > 0) {
                for (int i = 0; i < left.size();i++) {
                    ArrayList<Integer> one = (ArrayList<Integer>)left.get(i);
                    one.add(0, root.val);
                }
            }

            if (right != null && right.size() > 0) {
                for (int i = 0; i < right.size();i++) {
                    ArrayList<Integer> one = (ArrayList<Integer>)right.get(i);
                    one.add(0, root.val);
                }
            }
        }
        return result;
    }
    public ArrayList<String> bfs(String s) {
        ArrayList<String> result = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();

        Deque<String> queue = new ArrayDeque<String>();
        queue.addLast(s);
        int max = 0;
        while(!queue.isEmpty()) {
            String str = queue.pollFirst();
            if (str.length() < max) {
                continue;
            }
            if (isValid(str)) {
                max = str.length();
                if (set.add(str)) {
                    result.add(str);
                }
            } else {
                for (int i =0; i < str.length(); i++) {
                    String substr = str.substring(0,i) + str.substring(i+1);
                    queue.addLast(substr);
                }
            }
        }
        return result;

    }
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1 == null || nums1.length == 0) {
//            int n = nums2.length;
//            if (n % 2 == 0) {
//                return (nums2[n/2] + nums2[n/2 - 1] )/2.0;
//            } else {
//                return nums2[n / 2];
//            }
//        } else if (nums2 == null || nums2.length == 0) {
//            int n = nums1.length;
//            if (n % 2 == 0) {
//                return (nums1[n/2] + nums1[n/2 - 1] )/2.0;
//            } else {
//                return nums1[n / 2];
//            }
//        } else {
//            int m = nums1.length;
//            int n = nums2.length;
//            int k = (m + n) / 2;
//            if ((m + n) % 2 != 0) {
//                return findKth(nums1, 0, m-1, nums2, 0, n-1, k+1 );
//            } else {
//                return (findKth(nums1, 0, m-1, nums2, 0, n-1, k ) + findKth(nums1, 0, m-1, nums2, 0, n-1, k + 1 ) )/2.0;
//            }
//
//        }
//    }


    //k is 1 based
//    public double findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        if (start1 > end1) {
//            return nums2[start2+k-1];
//        } else if (start2 > end2) {
//            return nums1[start1 + k - 1];
//        }
//        if (k == 1) {
//            return Math.min(nums1[start1], nums2[start2]);
//        }
//        if (end2 - start2 > end1 - start1) {
//            return findKth(nums2, start2, end2, nums1, start1, end1, k);
//        }
//
//        //nums1 is the longer one
//        int m = end1 - start1 + 1;
//        int n = end2 - start2 + 1;
//        if (nums1[end1] <= nums2[start2]) {
//
//            if (end1 - start1 >= k - 1) {
//                return nums1[start1 + k - 1];
//            } else {
//                return nums2[start2 + k - m - 1];
//            }
//        } else {
//            //maintain K elements always
//            int j = Math.min(end2 - start2 + 1, k / 2);  //nums2 is the shorter one, count
//            int i = k - j;
//            if (nums1[start1 + i -1] > nums2[start2 + j -1]) {
//                return findKth(nums1, start1, end1, nums2, start2 + j, end2, k-j);
//            } else {
//                return findKth(nums1, start1 + i, end1, nums2, start2, end2, k - i);
//            }
//
//
//        }
//
//
//    }
    public static void print(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        System.out.println();
        for (int num: nums) {
            System.out.print(num+", ");
        }
    }

    public void quicksort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        quicksort(nums, 0, nums.length - 1);
    }

    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int i = start;
        int j = end;
        while (i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else if (nums[j] > pivot) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        //j point
        swap(nums, start, j);
        quicksort(nums, start, j-1);
        quicksort(nums, j+1, end);
    }
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


}
