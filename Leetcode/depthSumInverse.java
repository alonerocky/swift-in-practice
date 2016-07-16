public int depthSumInverse(List<NestedInteger> nestedList) {
        return dfs(nestedList, 0);
    }
    public int dfs(List<NestedInteger> nestedList, int lastLevelSum) {
        List<NestedInteger> nextLevel = new ArrayList<NestedInteger>();
        
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger one = nestedList.get(i);
            if (one.isInteger()) {
                lastLevelSum += one.getInteger();
            } else {
                nextLevel.addAll(one.getList());
            }
        }
        return nextLevel.isEmpty() ? lastLevelSum : lastLevelSum + dfs(nextLevel, lastLevelSum);
    }
    public int depthSumInverseII(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList, 1);
        return depthSumInverse(nestedList, depth);
    }
    
    public int depthSumInverse(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger ni = nestedList.get(i);
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += depthSumInverse(ni.getList(), depth - 1);
            }
            
        }
        return sum;
    }
    private int getDepth(List<NestedInteger> nestedList , int depth) {
        int max = 0;
        for(int i =0; i < nestedList.size(); i++) {
            max = Math.max(max, getDepth(nestedList.get(i), depth));
        }
        return max;
    }
    private int getDepth(NestedInteger n , int depth) {
        if (n.isInteger()) {
            return depth;
        }
        int max = 0;
        List<NestedInteger> list = n.getList();
        for(int i = 0; i < list.size(); i++) {
            max = Math.max(max, getDepth(list.get(i), depth + 1));
        }
        return max;
    }
    /*
    public int DFS(List<NestedInteger> nestedList, int intSum) {
    //关键点在于把上一层的integer sum传到下一层去，这样的话，接下来还有几层，每一层都会加上这个integer sum,也就等于乘以了它的层数
    List<NestedInteger> nextLevel = new ArrayList<>();
    int listSum = 0;
    for (NestedInteger list : nestedList) {
        if (list.isInteger()) {
            intSum += list.getInteger();
        } else {
            nextLevel.addAll(list.getList());
        }
    }
    listSum = nextLevel.isEmpty() ? 0 : DFS(nextLevel, intSum);
    return listSum + intSum;
}

public int depthSumInverse(List<NestedInteger> nestedList) {
    return DFS(nestedList, 0);
}
    */
