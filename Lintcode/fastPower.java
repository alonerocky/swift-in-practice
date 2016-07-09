public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        long c = fastPower(a, b, n/2);
        c = c * c % b;
        if (n % 2 == 0) {
            return (int)c;
        } else {
            return (int)(c * a % b);
        }
    }
