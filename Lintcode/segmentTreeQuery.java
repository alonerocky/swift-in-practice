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


public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
         if (start > end || end < root.start || start > root.end) {
             return Integer.MIN_VALUE;
         }
         if (start <= root.start && end >= root.end) {
             return root.max;
         }
         int middle = (root.start + root.end)/2;
         int left = query(root.left, start, Math.min(middle, end));
         int right = query(root.right, Math.max(start,middle+1), end);
         return Math.max(left, right);
    }
