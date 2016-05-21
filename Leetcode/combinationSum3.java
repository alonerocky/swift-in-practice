public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(1,  k, n, result, new ArrayList<Integer>());
        return result;
    }
    
    public void helper(int start, int k, int remaining, List<List<Integer>> result,  List<Integer> oneResult) {
        if (remaining == 0) {
            if (oneResult.size() == k) {
                result.add(new ArrayList<Integer>(oneResult));
            }
        } else if (remaining > 0 ) {
            for (int i = start; i <= 9; i++) {
                oneResult.add(i);
                helper(i+1, k, remaining - i, result, oneResult);
                oneResult.remove(oneResult.size() - 1);
            }
             
        }
    }
