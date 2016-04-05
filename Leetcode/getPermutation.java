public String getPermutation(int n, int k) {
        
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        
        StringBuffer result = new StringBuffer();
        int m = k - 1;
        while (n > 0) {
            int fact = factor(n-1);
            int a = m / fact;
            result.append(sb.charAt(a));
            sb.deleteCharAt(a);
            m = m % fact;
            n--;
        }
        return result.toString();
    }
    public String getPermutationII(int n, int k) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        return getPermutation(sb, k-1);
    }

    public String getPermutation(StringBuffer p, int k) {
        if (k == 0) {
            return p.toString();
        }
        else {
            StringBuffer sb = new StringBuffer();
            int fact = factor(p.length() - 1);
            int a = k / fact;
            sb.append(p.charAt(a));
            p.deleteCharAt(a);
            sb.append(getPermutation(p, k % fact));
            return sb.toString();
        }
    }
    private HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    private int factor(int n) {  //n!
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 1 || n == 0) {
            cache.put(n, 1);
            return 1;
        } else  {
            int result = n * factor(n-1);
            cache.put(n, result);
            return result;
        }
    }
