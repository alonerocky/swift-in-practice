public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int levels = triangle.size();
        List<Integer> result = triangle.get(levels-1);
        for (int i = levels - 2; i >= 0; i--) {
            List<Integer> currentLevel = triangle.get(i);
            for (int j = 0; j < currentLevel.size();j++) {
                result.set(j, Math.min(result.get(j), result.get(j+1)) + currentLevel.get(j));
            }
        }
        return result.get(0);
    }
