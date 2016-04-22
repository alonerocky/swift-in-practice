//https://leetcode.com/discuss/84659/short-ruby-python-java-c
    //https://en.wikipedia.org/wiki/Eulerian_path#Hierholzer.27s_algorithm
    public List<String> findItinerary(String[][] tickets) {
        List<String> routes = new ArrayList<String>();
        
        HashMap<String, PriorityQueue<String>> adjacents = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String from = ticket[0];
            String to = ticket[1];
            if(!adjacents.containsKey(from)) {
                adjacents.put(from, new PriorityQueue<String>());
            }
            adjacents.get(from).offer(to);
        }
        dfs("JFK", adjacents, routes);
        
        return routes;
    }
    
    public void dfs(String u, HashMap<String, PriorityQueue<String>> adjacents, List<String> routes) {
        
        if (adjacents.containsKey(u)) {
            PriorityQueue<String> neighbors = adjacents.get(u);
            while(adjacents.get(u).size() > 0) {
                //similar to remove one in degree
                dfs(neighbors.poll(), adjacents, routes);
            }
        }
        routes.add(0, u);
    }
