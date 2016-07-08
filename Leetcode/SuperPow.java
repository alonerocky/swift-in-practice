public int superPow(int a, int[] b) {
        if (b == null || b.length == 0) {
            return 0;
        }
        int result = 1;
        int c = 1;
        int mod = 1337;
        for(int i = b.length - 1; i >= 0; i--) {
            result = result * pow(a, b[i], mod) % mod;
            a = pow(a, 10, mod) ;
        }
        return result;
    }
    
    public int pow(int a, int b, int mod) {
         
        a = a % mod;
        int result = 1;
        
        while( b > 0) {
            if ((b & 1) !=0) result = result * a % mod;
			a = a * a % mod;
			b >>= 1;
        }
        return result % mod;
    }
