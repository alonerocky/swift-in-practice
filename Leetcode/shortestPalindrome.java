public String shortestPalindrome(String s) {
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
    public String reverse(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
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


//kmp
//http://yucoding.blogspot.com/2015/10/leetcode-question-shortest-palindrome.html
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String str = s+"#"+reverse(s);
        
        int[] failure = next(str);
        //longest comment prefix is failure[str.length]
        int commonLen = failure[failure.length - 1];
        if (commonLen >= s.length()) {
            return s;
        }
        String postfix = s.substring(commonLen);
        
        return reverse(postfix) + s;

    }
    public int[] next(String s) {
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
        return next;
    }
