public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (k > m * n) {
            return 0;
        }
        //return kthSmallest_row(matrix, k);
        return kthSmallest_column(matrix, k);
    }
    
    
    public int kthSmallest_column(int[][] matrix, int k) {
        Comparator<Entry> comparator = new Comparator<Entry>() {
            @Override
            public int compare(Entry e1, Entry e2) {
                return e1.value - e2.value;
            }
        };
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(k, comparator);
        int size = Math.min(k, n);
        for(int i = 0; i < size; i++) {
            minHeap.offer(new Entry(0, i, matrix[0][i]));
        }
        for(int i = 0; i < k-1; i++) {
            Entry min = minHeap.poll();
            if (min.i + 1 < m) {
                minHeap.offer(new Entry(min.i+1, min.j, matrix[min.i+1][min.j]));
            }
        }
        return minHeap.peek().value;
        
    }
    public int kthSmallest_row(int[][] matrix, int k) {
        Comparator<Entry> comparator = new Comparator<Entry>() {
            @Override
            public int compare(Entry e1, Entry e2) {
                return e1.value - e2.value;
            }
        };
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(k, comparator);
        int size = Math.min(m, k);
        for(int i = 0;i < size; i++) {
            minHeap.offer(new Entry(i, 0, matrix[i][0]));
        }
        //pop out k-1 elements
        for(int i = 0; i < k-1; i++) {
            Entry min = minHeap.poll();
            if (min.j < n - 1) {
                minHeap.offer(new Entry(min.i, min.j + 1, matrix[min.i][min.j+1]));
            }
        }
        return minHeap.peek().value;
    }
    class Entry {
        int i ,j, value;
        public Entry(int i , int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
        
    }
