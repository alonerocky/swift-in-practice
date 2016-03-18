public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        char[] chars = new char[4];
        int i =0;
        while ( i < n) {
            int nums = read4(chars);
            int len = Math.min(n - i, nums);
            System.arraycopy(chars, 0, buf, i, len);
            i += len;
            if (nums < 4) {
                break;
            }
        }
        return i;
    }
