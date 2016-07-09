public int firstMissingPositive(int[] A) {
        // write your code here    
        if (A == null || A.length == 0) {
            return 1;
        }
        int len = A.length;
        for(int i = 0; i < len; i++) {
            if (A[i] <= 0) {
                A[i] = len + 1;
            }
        }
        for(int i = 0; i < len; i++) {
            int n = A[i];
            int index = Math.abs(n);
            if (index > 0 && index <= len && A[index-1] > 0) {
                A[index-1] = -A[index-1];
            }
        }
        
        int i = 0;
        for(; i < len; i++) {
            if (A[i] > 0) {
                break;
            }
        }
        return i + 1;
    }
