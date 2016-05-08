public void mutate(int[] A, int[] pos) {
        if (A == null || A.length == 0 || pos == null || pos.length == 0) {
            return;
        }
         
        int i = 0;
        while (i < A.length) {
            if (pos[i] != i) {
                swap(A, i, pos[i]);
                swap(pos, i, pos[i]);
            } else {
                i++;
            }
        }
    }
 
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
