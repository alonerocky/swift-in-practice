public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return build(A, 0, A.length - 1);
    }
    public SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        } else {
            int middle = (start + end)/2;
            SegmentTreeNode left = build(A, start, middle);
            SegmentTreeNode right = build(A, middle+1, end);
            SegmentTreeNode root = new SegmentTreeNode(start, end, Math.max(left.max, right.max));
            root.left = left;
            root.right = right;
            return root;
        }
    }
