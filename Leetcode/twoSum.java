public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i =0;
        int j = numbers.length - 1;
        while (i < j) {
            int total = numbers[i] + numbers[j];
            if (total == target) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            } else if (total < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {-1,-1};
    }
