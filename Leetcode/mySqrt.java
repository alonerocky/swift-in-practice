public int mySqrtI(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        //x >= 4
        //x / 4 >= 1
        //sqrt(x) >= 2
        int i = 1;
        int j = x;
        while(i <= j) {
            int middle = i + (j - i)/2;
            int m = middle * middle;
            if (m == x) {
                return middle;
            } else if (m < x) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return j;
    }
    
    public int mySqrtII(int x) {
        if (x < 1) {
            return 0;
        }
        double x0 = 1.0;
        double delta = 1.0;
        do {
            double x1 = (x0 + (double)x/x0)/2.0;
            delta = Math.abs(x1- x0);
            x0 = x1;
        } while (delta > 1e-6);
        return (int)x0;
    }
