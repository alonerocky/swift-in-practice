public int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] bits = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                int num = A[j];
                bits[i] += ((num >> i) & 0x1);
                 
            }
            bits[i] = bits[i] % 3;
            result |= bits[i] << i;
        }
        return result;
    }
