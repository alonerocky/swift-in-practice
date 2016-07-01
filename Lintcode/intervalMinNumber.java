public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return result;
        }
        SegmentTreeNode root = buildSegmentTree(A, 0, A.length - 1);
        if (root == null) {
            return result;
        }
        for(int i = 0; i < queries.size();i++) {
            Interval interval = queries.get(i);
            result.add(query(root, interval.start, interval.end));
        }
        return result;
    }
    
    public SegmentTreeNode buildSegmentTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        } else {
            int middle = (start + end)/2;
            SegmentTreeNode left = buildSegmentTree(A, start, middle);
            SegmentTreeNode right = buildSegmentTree(A, middle + 1, end);
            SegmentTreeNode root = new SegmentTreeNode(start, end, Math.min(left.min, right.min));
            root.left = left;
            root.right = right;
            return root;
        }
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end || start > root.end || end < root.start) {
            return Integer.MAX_VALUE;
        }
        if (start <= root.start && end >= root.end ) {
            return root.min;
        } else {
            int middle = (root.start + root.end)/2;
            int left = query(root.left, start, Math.min(middle, end));
            int right = query(root.right, Math.max(middle+1, start), end);
            return Math.min(left, right);
        }
    }
    
    class SegmentTreeNode {
        public int start, end, min;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
        }
    }
