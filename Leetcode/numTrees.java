public int numTrees(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 0 || n == 1) {
            cache.put(n, 1);
            return 1;
        }
	int total = 0;
        for (int i = 1; i <= n; i++) {
            //1.. i-1
            //i+1, n
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            total += left * right;
        }
        cache.put(n, total);
        return total;
    }
