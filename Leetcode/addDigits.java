public int addDigits(int num) {
        while (num >= 10) {
            int temp = num;
            int result = 0;
            while (temp > 0) {
                int a = temp % 10;
                result += a;
                temp = temp / 10;
            }
            num = result;
        }
        return num;
    }
