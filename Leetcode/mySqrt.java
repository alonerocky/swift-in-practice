 public int sqrt(int x) {
        // write your code here
        if (x == 0) {
            return 0;
        }
        if (x <= 3) {
            return 1;
        }
        int i = 2;
        int j = x/2 + 1;
        while (i <= j) {
            int middle = i + (j-i)/2;
            int other = x / middle;
            if (middle == other) {
                return middle;
            } else if (middle < other) {
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
