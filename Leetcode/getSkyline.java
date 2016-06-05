public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        //create the edge array
        ArrayList<Edge> edges = new ArrayList<Edge>();
        int n = buildings.length;
        for(int i = 0; i < n; i++) {
            int[] building = buildings[i];
            //l, r, height
            Edge left = new Edge(building[0], building[2], true);
            edges.add(left);
            Edge right = new Edge(building[1], building[2], false);
            edges.add(right);
        }
        //
        Comparator<Edge> edgeComparator = new Comparator<Edge>() {
          @Override
          public int compare(Edge e1, Edge e2) {
              if (e1.x != e2.x) {
                  return e1.x - e2.x;
              }
              if (e1.isStart && e2.isStart) {
                  return e2.height - e1.height;
              }
              if (!e1.isStart && !e2.isStart) {
                  return e1.height - e2.height;
              }
              return e1.isStart ? -1 : 1;
          }
        };
        
        Collections.sort(edges, edgeComparator);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        for(int i = 0; i < edges.size(); i++) {
            
            Edge edge = edges.get(i);
            if (edge.isStart) {
                if (maxHeap.isEmpty() || edge.height > maxHeap.peek()) {
                    result.add(new int[] {edge.x, edge.height});
                }
                maxHeap.offer(edge.height);
            } else {
                maxHeap.remove(edge.height);
                if (maxHeap.isEmpty()) {
                    result.add(new int[] {edge.x, 0});
                } else if (edge.height > maxHeap.peek()) {
                    result.add(new int[]{edge.x, maxHeap.peek()});
                }
            }
             
        }
        return result;
    }
    
    class Edge {
        int x ;
        int height;
        boolean isStart;
        public Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
