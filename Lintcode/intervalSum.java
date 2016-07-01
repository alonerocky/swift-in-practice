public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return result;
        }
        SegmentTreeNode root = buildSegmentTree(A, 0, A.length - 1);
        for(int i = 0; i < queries.size();i++) {
            Interval interval = queries.get(i);
            result.add(query(root, interval.start, interval.end));
        }
        return result;
    }
    private SegmentTreeNode buildSegmentTree(int[] A, int start, int end) {
        if (A == null || A.length == 0 || start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = (start + end)/2;
        SegmentTreeNode left = buildSegmentTree(A, start, mid);
        SegmentTreeNode right = buildSegmentTree(A, mid+1, end);
        SegmentTreeNode root = new SegmentTreeNode(start, end, left.sum + right.sum);
        root.left = left;
        root.right = right;
        return root;
    }
    private long query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end || start > root.end || end < root.start) {
            return 0;
        }
        if (start <= root.start && end >= root.end) {
            return root.sum;
        }
        int mid = (root.start + root.end)/2;
        return query(root.left, start, Math.min(end, mid)) + 
               query(root.right, Math.max(start, mid+1), end);
    }
    
    class SegmentTreeNode {
        public SegmentTreeNode left, right;
        public int start, end;
        public long sum;
        public SegmentTreeNode(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
        public SegmentTreeNode(int start, int end) {
            this(start, end, 0);
        }
    }
