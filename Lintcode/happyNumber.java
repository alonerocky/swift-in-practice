public boolean isHappy(int n) {
        // Write your code here
        if (n < 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1) {
            int r = 0;
            while(n != 0) {
                int d = n % 10;
                r += d * d;
                n /= 10;
            }
            if (r == 1) {
                break;
            }
            if (set.contains(r)) {
                return false;
            }
            set.add(r);
            n = r;
        }
        return true;
    }
