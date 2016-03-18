public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        int m = n;
        while (m != 1) {
            int result = 0;
            while (m > 0) {
                int mod = m % 10;
                result += mod * mod;
                m = m / 10;
            }
            if (result == 1) {
                return true;
            } else if (set.add(result)) {
                m = result;
            } else {
                return false;
            }
        }
        return true;
    }
