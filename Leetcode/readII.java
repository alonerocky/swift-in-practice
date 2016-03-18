private char[] buffer = new char[4];
     private int lastIndex = 4;   
     private int lastLen = 0;
    public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        int i = 0;
        while (i < n) {
            //try to read from the buff last read
            
            if (lastLen > 0) {
                int len = Math.min(lastLen, n - i);
                System.arraycopy(buffer, lastIndex, buf, i, len);
                //update lastIndex & lastLen
                lastLen -= len;
                lastIndex += len;
                i+= len;
            }
            if (i == n) {
                break;
            }
            
            int nums = read4(buffer);
            int len = Math.min(n - i, nums);
            System.arraycopy(buffer, 0, buf, i, len);
            lastIndex = len;
            lastLen = nums - len;
            
            i+= len;
            //we reach the end of file
            if (nums < 4) {
                break;
            }
        }
        return i;
    }
