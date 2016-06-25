c void rotateStringII(char[] str, int offset) {
        // write your code here
        //[len - offset , len-1]  to [0, offset-1]  == offset 
        //[0, len-offset -1, ] to [offset, len-1] = len-offset
        int len = str.length;
        if (str == null || str.length == 0 || offset <= 0 ) {
            return;
        }
        offset = offset % len;
        char[] s = new char[len];
        System.arraycopy(str, 0, s, offset, len-offset);
        System.arraycopy(str,len-offset, s, 0, offset);
        System.arraycopy(s, 0, str,0, len);
    }
    
    public void rotateString(char[] str, int offset) {
        // write your code here
        //[len - offset , len-1]  to [0, offset-1]  == offset 
        //[0, len-offset -1, ] to [offset, len-1] = len-offset
        int len = str.length;
        if (str == null || str.length == 0 || offset <= 0 ) {
            return;
        }
        offset = offset % len;
        
        reverse(str, 0, len-offset-1);
        reverse(str, len-offset, len-1);
        reverse(str, 0, len-1);
        
    }
    
    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
