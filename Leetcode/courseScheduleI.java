   private enum State {UNVISITED, VISITING, VISITED}
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        State[] visit = new State[numCourses];
        HashMap<Integer, ArrayList<Integer>> adjacent = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] one = prerequisites[i];
            if (adjacent.containsKey(one[0])) {
                adjacent.get(one[0]).add(one[1]);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(one[1]);
                adjacent.put(one[0], list);
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
