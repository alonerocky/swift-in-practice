import java.util.*;

/**
 * Created by shoulongli on 5/1/16.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }


    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<Integer, DirectedGraphNode> adjacents = new HashMap<Integer, DirectedGraphNode>();
        HashMap<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        buildAdjacentsAndIndegree(graph, adjacents, indegree);
        ArrayList<Integer> order = new ArrayList<Integer>();
        bfs(adjacents, indegree, order);
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        for (int i = 0; i < order.size(); i++) {
            result.add(adjacents.get(order.get(i)));
        }
        return result;
    }

    public void buildAdjacentsAndIndegree(ArrayList<DirectedGraphNode> graph, HashMap<Integer, DirectedGraphNode> adjacents, HashMap<Integer, Integer> indegree) {

        for (int i = 0; i < graph.size(); i++) {
            int u = graph.get(i).label;
            indegree.put(u, 0);
        }
        for (int i = 0; i < graph.size(); i++) {
            DirectedGraphNode u = graph.get(i);
            adjacents.put(u.label, u);
        }
        for (int i = 0; i < graph.size(); i++) {
            int u = graph.get(i).label;
            ArrayList<DirectedGraphNode> neighbors = graph.get(i).neighbors;
            for (int j = 0; j < neighbors.size(); j++) {
                int v = neighbors.get(j).label;
                indegree.put(v, indegree.get(v) + 1);
            }
        }
    }



    public boolean bfs(HashMap<Integer, DirectedGraphNode> adjacents, HashMap<Integer, Integer> indegree, ArrayList<Integer> order) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        Iterator<Integer> iterator = indegree.keySet().iterator();
        while (iterator.hasNext()) {
            int u = iterator.next();
            if (indegree.get(u) == 0) {
                queue.addLast(u);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            order.add(u);
            if (adjacents.containsKey(u)) {
                DirectedGraphNode g = adjacents.get(u);
                ArrayList<DirectedGraphNode> neighbors = g.neighbors;
                for (int i = 0; i < neighbors.size(); i++) {
                    int v = neighbors.get(i).label;
                    indegree.put(v, indegree.get(v) - 1);
                    if (indegree.get(v) == 0) {
                        queue.addLast(v);
                    }
                }
            }
        }
        return order.size() == indegree.size();
    }

    public void buildAdjacentsAndState(ArrayList<DirectedGraphNode> graph, HashMap<Integer, DirectedGraphNode> adjacents, HashMap<Integer, Integer> state) {

        for (int i = 0; i < graph.size(); i++) {
            int u = graph.get(i).label;
            state.put(u, 0);
        }
        for (int i = 0; i < graph.size(); i++) {
            DirectedGraphNode u = graph.get(i);
            adjacents.put(u.label, u);
        }
    }

    public boolean dfs(int u, HashMap<Integer, DirectedGraphNode> adjacents, HashMap<Integer, Integer> visited, ArrayList<Integer> order) {
        visited.put(u, 1); //visiting

        ArrayList<DirectedGraphNode> neighbors = adjacents.get(u).neighbors;
        for (int i = 0; i < neighbors.size();i++) {
            DirectedGraphNode v = neighbors.get(i);
            if (visited.get(v.label) == 1) {
                return false;
            } else if (visited.get(v.label) == 0) {
                if (!dfs(v.label, adjacents, visited, order)) {
                    return false;
                }
            }
        }

        visited.put(u, 2);//visited;
        order.add(0, u);
        return true;

    }

    public ArrayList<DirectedGraphNode> topSort_dfs(ArrayList<DirectedGraphNode> graph) {
        HashMap<Integer, DirectedGraphNode> adjacents = new HashMap<Integer, DirectedGraphNode>();
        HashMap<Integer, Integer> state = new HashMap<Integer, Integer>();
        buildAdjacentsAndState(graph, adjacents, state);
        Iterator<Integer> iterator = adjacents.keySet().iterator();
        ArrayList<Integer> order = new ArrayList<Integer>();


        while(iterator.hasNext()) {
            int u = iterator.next();
            if (state.get(u) == 0) {
                dfs(u, adjacents, state, order);
            }
        }
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        for (int i = 0; i < order.size(); i++) {
            result.add(adjacents.get(order.get(i)));
        }
        return result;
    }


    //----------------------has route
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here

        HashMap<Integer, Integer> state = new HashMap<Integer, Integer>();
        return dfs(s, t, state);
    }

    public boolean dfs(DirectedGraphNode s, DirectedGraphNode t, HashMap<Integer, Integer> state) {
        if (s == t) {
            return true;
        }
        state.put(s.label, 1);
        ArrayList<DirectedGraphNode> neighbors = s.neighbors;
        for (int i = 0; i < neighbors.size(); i++) {

            DirectedGraphNode v = neighbors.get(i);

            if (!state.containsKey(v.label) && dfs(v, t, state)) {
                return true;
            }
        }
        state.put(s.label, 2);
        return false;
    }


    public boolean bfs(DirectedGraphNode s, DirectedGraphNode t) {

        Deque<DirectedGraphNode> queue = new ArrayDeque<DirectedGraphNode>();
        queue.addLast(s);
        HashSet<Integer> used = new HashSet<Integer>();
        used.add(s.label);
        while(!queue.isEmpty()) {
            DirectedGraphNode front = queue.pollFirst();
            if (front == t) {
                return true;
            }
            ArrayList<DirectedGraphNode> neighbors = front.neighbors;
            for (int i = 0; i < neighbors.size();i++) {
                DirectedGraphNode v = neighbors.get(i);
                if(!used.contains(v)) {
                    used.add(v.label);
                    queue.addLast(v);
                }
            }
        }
        return false;
    }
}
