public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> predecessor = new Stack<Integer>();
        Stack<Integer> successor = new Stack<Integer>();
        getPredecessor(root, target, predecessor);
        getSuccessor(root, target, successor);
        for (int i = 0; i < k; i++) {
            if (predecessor.isEmpty()) {
                result.add(successor.pop());
            } else if (successor.isEmpty()) {
                result.add(predecessor.pop());
            } else if (Math.abs(predecessor.peek() - target) <= Math.abs(successor.peek() - target)) {
                result.add(predecessor.pop());
            } else {
                result.add(successor.pop());
            }
        }
        return result;
        
    }
    
    public void getPredecessor(TreeNode root, double target, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        getPredecessor(root.left, target, stack);
        if (root.val > target) {
            return;
        }
        stack.push(root.val);
        getPredecessor(root.right, target, stack);
    }
    public void getSuccessor(TreeNode root, double target, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        getSuccessor(root.right, target, stack);
        if (root.val <= target) {
            return;
        }
        stack.push(root.val);
        getSuccessor(root.left, target, stack);
    }


public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        final double t = target;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                double d1 = Math.abs((double)i1.intValue() - t);
                double d2 = Math.abs((double)i2.intValue() - t);
                if (d1 == d2) {
                    return 0;
                } else if (d1 < d2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, comparator);
        preorder(root, maxHeap, k);
        return new ArrayList<Integer>(maxHeap);
    }
    
    public void preorder(TreeNode root, PriorityQueue<Integer> maxHeap, int k) {
        if (root == null) {
            return;
        }
        maxHeap.offer(root.val);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
        preorder(root.left, maxHeap, k);
        preorder(root.right, maxHeap, k);
    }




public List<Integer> closestKValuesI(TreeNode root, final double target,  int k) {
        List<Integer> result = new ArrayList<Integer>();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        inorder(root, target, maxHeap, minHeap);
        for(int i = 0; i < k; i++) {
            
            if (maxHeap.isEmpty()) {
                result.add(minHeap.poll());
            } else if (minHeap.isEmpty()) {
                result.add(maxHeap.poll());
            } else {
                if (Math.abs(minHeap.peek() - target) < Math.abs(maxHeap.peek() - target)) {
                    result.add(minHeap.poll());
                } else {
                    result.add(maxHeap.poll());
                }
            }
            
        }
        return result; 
    }
    
    public void inorder(TreeNode root, double target, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (root == null) {
            return;
        }
        if (root.val <= target) {
            maxHeap.offer(root.val);
        } else {
            minHeap.offer(root.val);
        }
        inorder(root.left, target, maxHeap, minHeap);
        inorder(root.right, target, maxHeap, minHeap);
    }
    
    
    public List<Integer> closestKValuesII(TreeNode root, final double target,  int k) {
        
        List<Integer> result = new ArrayList<Integer>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            
            @Override
            public int compare(Integer i1, Integer i2) {
                return (int)(Math.abs(i2 - target) - Math.abs(i1 - target));
            }
        };
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, comparator);
        inorder(root, maxHeap, target, k);
        while(!maxHeap.isEmpty()) {
            result.add(0, maxHeap.poll());
        }
        return result;
        
    }
    
    public void inorder(TreeNode root, PriorityQueue<Integer> maxHeap, double target, int k) {
        if (root == null) {
            return;
        }
        if (maxHeap.size() < k) {
            maxHeap.offer(root.val);
        } else if (Math.abs(root.val - target) > Math.abs(maxHeap.peek() - target)) {
            //do nothing
        } else {
            maxHeap.poll();
            maxHeap.offer(root.val);
        }
        inorder(root.left, maxHeap, target, k);
        inorder(root.right, maxHeap, target, k);
    }
