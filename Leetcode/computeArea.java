public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //(left, bottom, right, top)
        // A      B      C     D
        // E      F      G     H
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        int result = areaA + areaB;
        if (C <= E || A >= G || B >= H || D <= F ) {
            return result;
        }
       
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int overlap =  (right - left) * ( top - bottom);
        return result - overlap;
    }
