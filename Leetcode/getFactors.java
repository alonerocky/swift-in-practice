public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> factors = new ArrayList<Integer>();
        tryNextFactor(result, factors, n, 2);
        return result;
    }
    
    public void tryNextFactor(List<List<Integer>> result, List<Integer> factors, int n, int start) {
        if (n == 1) {
            if (factors.size() > 1) { //not prime
                result.add(new ArrayList<Integer>(factors));
            }
            
        } else {
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    factors.add(i);
                    tryNextFactor(result, factors, n/i, i);
                    factors.remove(factors.size()-1);
                }
            }
        }
    }
