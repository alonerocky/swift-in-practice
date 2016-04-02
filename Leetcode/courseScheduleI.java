   private enum State {UNVISITED, VISITING, VISITED}
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        State[] visit = new State[numCourses];
        HashMap<Integer, ArrayList<Integer>> adjacent = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] one = prerequisites[i];
	    //[a,b] To take course a you should have finished course b
	    //b-->a  ,b happens before a (if in toplogical sort)
            if (adjacent.containsKey(one[1])) {
                adjacent.get(one[1]).add(one[0]);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(one[0]);
                adjacent.put(one[1], list);
            }
        }
        for (int i =0; i < numCourses; i++) {
            visit[i] = State.UNVISITED;
        }
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == State.UNVISITED) {
                if (isCyclic(adjacent,i, visit)) {
                    return false;
                }
            }
        }
        return true;

    }
    public boolean isCyclic(HashMap<Integer, ArrayList<Integer>> adjacent, int vertex, State[] visit) {
        visit[vertex] = State.VISITING;
        if (adjacent.containsKey(vertex)) {
            Iterator<Integer> iterator = adjacent.get(vertex).iterator();
            while (iterator.hasNext()) {
                int u = iterator.next();
                if (visit[u] == State.VISITING) {
                    return true;
                } else if (visit[u] == State.UNVISITED) {
                    if (isCyclic(adjacent, u, visit)) {
                        return true;
                    }
                }
            }
        }
        visit[vertex] = State.VISITED;
        return false;
    }
