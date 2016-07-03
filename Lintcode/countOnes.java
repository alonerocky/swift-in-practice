public int countOnes(int num) {
        // write your code here
         
         
        int count = 0;
        while(num != 0) {
            num = num & (num - 1);
            count++; //count the least 1 bit
        }
        return count;
    }
