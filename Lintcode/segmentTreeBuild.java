public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end);
        } else {
            int middle = (start + end)/2;
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            root.left = build(start, middle);
            root.right = build(middle + 1, end);
            return root;
        }
    }
