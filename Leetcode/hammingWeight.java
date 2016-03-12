public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            int lastBit = n & 1;
            if (lastBit == 1) {
                num++;
            }
            n = n >>> 1;
        }
        return num;
    }public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            int lastBit = n & 1;
            if (lastBit == 1) {
                num++;
            }
            n = n >> 1;
        }
        return num;
    }
