public boolean isIsoMorphic(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
         
        if (root1 == null || root2 == null) {
            return false;
        }
         
        if (root1.val != root2.val) {
            return false;
        }
         
        return (isIsoMorphic(root1.left, root2.left) && (isIsoMorphic(root1.right, root2.right)) ||
               (isIsoMorphic(root1.left, root2.right) && (isIsoMorphic(root1.right, root2.left)));
    }
