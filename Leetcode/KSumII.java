public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
          // write your code here
         ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> path = new ArrayList<Integer>();
         helper(res, path, A, k, target, 0);
         return res;
     }
     
     public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int[] A, int k, int remain, int index			) {
         if (path.size() == k) {
             if (remain == 0) {
                 res.add(new ArrayList<Integer>(path));
             }
             return;
         }
         for (int i=index; i<A.length; i++) {
             path.add(A[i]);
             helper(res, path, A, k, remain-A[i], i+1);
             path.remove(path.size()-1);
         }
     }
