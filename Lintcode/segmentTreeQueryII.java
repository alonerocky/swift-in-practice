 public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null || start > root.end || end < root.start) {
            return 0;
        }
        if (start <= root.start && end >= root.end) {
            return root.count;
        }
        int mid = (root.start + root.end)/2;
        return query(root.left, start, Math.min(mid, end)) +
               query(root.right, Math.max(start, mid+1), end);
    }
