public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length ) {
            return 2.0;
        }
        int n = A.length;
        double a = 0;
        double b = 0;
        double c = 0;
        for(int i = 0; i < n; i++) {
            a += A[i] * B[i];
            b += A[i] * A[i];
            c += B[i] * B[i];
             
        }
        if (b == 0 || c == 0) {
            return 2.0;
        }
        return a/(Math.sqrt(b) * Math.sqrt(c));
    }
