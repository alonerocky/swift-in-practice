public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int m = x;
        int n = 1;
        while (m >= 10) {
            m = m/10;
            n = n * 10;
        }
        
        while (x > 0) {
            int right = x % 10;
            int left = x / n;
            if (left != right) {
                return false;
            }
            x = x % n;
            x = x /10;
            n = n / 100;
        }
        return true;
    }
