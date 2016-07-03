 public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if (key == null || key.length == 0 || HASH_SIZE <= 0) {
            return 0;
        }
        int len = key.length;
        long r = 1;
        long hash = 0;
        for(int i = len-1; i >= 0; i--) {
            hash += key[i] * r  ;
            
            r *= 33;
            hash %= HASH_SIZE;
            r %= HASH_SIZE;
        }
        return (int)hash ;
    }
