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
                dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
            }
            for (int i= 1; i <= len2; i++) {
                dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
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
    public boolean isInterleaveI(String s1, String s2, String s3) {
        if (s1 == null && s2 == null) {
            return s3 == null;
        } else if (s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2.length() == 0) {
            return s1.equals(s3);
        } else {
            return (s1.charAt(0) == s3.charAt(0)  && isInterleave(s1.substring(1), s2, s3.substring(1))) ||
                   (s2.charAt(0) == s3.charAt(0)  && isInterleave(s1, s2.substring(1), s3.substring(1)));
        }
    }
