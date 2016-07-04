public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for(int i =0; i <= n; i++) {
            count += digits(i, k);
        }
        return count;
    }
    
    private int digits(int num, int k) {
        if (k == 0) {
            if (num == 0) {
                return 1;
            }
        }
        int count = 0;
        while(num > 0) {
            int d = num % 10;
            if (d == k) {
                count++;
            }
            num = num/10;
        }
        return count;
    }
