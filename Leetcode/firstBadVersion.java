public int firstBadVersion(int n) {
        int i = 1;
        int j = n;
        while (i <= j) {
            int median =  i + (j - i) / 2;
            if (isBadVersion(median)) {
                j = median - 1;
            } else {
                i = median + 1;
            }
        }
        return i;
    }
