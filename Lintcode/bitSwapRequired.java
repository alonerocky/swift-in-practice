public static int bitSwapRequired(int a, int b) {
        // write your code here
        int c = a ^ b;
        int r = 0;
        while (c != 0) {
            c = c & (c-1);
            r++;
        }
        return r;
    }
