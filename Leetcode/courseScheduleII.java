private enum State {UNVISITED, VISITING, VISITED}
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> toplogicalOrder = new Stack<Integer>();
        HashMap<Integer, ArrayList<Integer>> adjacent = new HashMap<Integer, ArrayList<Integer>>();
        State[] state = new State[numCourses];
        //initialize the state table
        for (int i =0;i < numCourses; i++) {
            state[i] = State.UNVISITED;
        }
        //create the adjacent table
        //[a, b]
        //means take a , you mush take b first
        for (int i = 0;i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            if (adjacent.containsKey(edge[1])) {
                adjacent.get(edge[1]).add(edge[0]);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(edge[0]);
                adjacent.put(edge[1], list);
            }
        }
        for (int i =0; i < numCourses; i++) {
            if (state[i] == State.UNVISITED) {
                if (!findOrder(adjacent, i, state, toplogicalOrder)) {
                    return new int[0];
                }
            }
        }
        //print out the order
        int[] result = new int[numCourses];
        int j = 0;
        while (!toplogicalOrder.isEmpty()) {
            result[j++] = toplogicalOrder.pop();
        }
        return result;
    }
    //true mean , there exist one toplogical sorting order
    private boolean findOrder(HashMap<Integer,ArrayList<Integer>> adjacent, int vertex, State[] visit, Stack<Integer> stack) {
        visit[vertex] = State.VISITING;

        if (adjacent.containsKey(vertex)) {

            Iterator<Integer> iterator = adjacent.get(vertex).iterator();
            while (iterator.hasNext()) {

                int u = iterator.next();
                if (visit[u] == State.VISITING) {
                    //find one cycle
                    return false;
                } else if (visit[u] == State.UNVISITED && !findOrder(adjacent, u, visit, stack)) {
                    return false;
                }
            }
        }
        stack.push(vertex);
        visit[vertex] = State.VISITED;
        return true;
    }
