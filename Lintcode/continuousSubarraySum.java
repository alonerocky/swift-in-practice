public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        int start = 0;
        int sum = 0;
        int max = A[0];
        int maxStart = 0;
        int maxEnd = 0;
        for(int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = 0;
                start = i;
            }
            sum += A[i];
            if (sum > max) {
                max = sum;
                maxStart = start;
                maxEnd = i;
            }
        }
        result.add(maxStart);
        result.add(maxEnd);
        return result;
    }
