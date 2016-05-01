//http://leetcode0.blogspot.com/2016/04/342-power-of-four.html
    public boolean isPowerOfFourI(int num) {
        HashSet<Integer> set = new HashSet<Integer>();
        int a = 1;
        for (int i =0; i < 16; i++) {
            set.add(a);
            a <<= 2;
        }
        return set.contains(num);
    }
    
    public boolean isPowerOfFourII(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        } else {
            return (num %4 == 0) && isPowerOfFour(num/4);
        }
    }
    //http://bookshadow.com/weblog/2016/04/18/leetcode-power-of-four/
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        } 
        return (num & (num-1)) == 0 && (num & 0x55555555) > 0;
    }
