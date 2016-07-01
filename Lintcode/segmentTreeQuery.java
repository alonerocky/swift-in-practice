public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null || start < root.start || end > root.end) {
            return 0;
        }
        if (start <= root.start && end >= root.end) {
            return root.max;
        }
        int mid = (root.start + root.end)/2;
        return Math.max(query(root.left, start, Math.min(end, mid)), 
                        query(root.right, Math.max(mid+1, start), end));
    }
