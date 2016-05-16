public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        //first we reverse the string
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
        
        //for the reversed word, we need reverse back
        i = 0;
        j = 0;
        int len = s.length;
        while(j < len) {
            //j always find the end of the string
            while(j < len && s[j] != ' ' ) {
                j++;
            }
            
            //j either point to end, or is space
            int m = i;
            int n = j-1;
            while(m < n) {
                swap(s, m++, n--);
            }
            
            i = ++j;
        }
        
    }
    
    private void swap(char[] s, int i , int j) {
        if (i != j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
