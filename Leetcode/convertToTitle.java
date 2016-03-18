public static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            int mod = (n - 1) % 26;
            char c = (char)('A' + mod );
            sb.insert(0, c);
            n = (n-1) /26;
        }
        return sb.toString();
    }
