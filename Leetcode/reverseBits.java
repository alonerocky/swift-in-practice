public int reverseBits(int n) {
        int i =0;
        int result = 0;
        while (i < 32) {
            int lastBit = n & (0x1 << i);
            if (lastBit != 0) {
                result |= 1 << (31 - i);
            }
            i++;
        }
        return result;
    }
