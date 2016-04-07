public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        //for right to left,
        //[i], has len - i elements that >= nums[i]
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (len - i <= citations[i]) {
                return len - i;
            }
        }
        return 0;
    }


public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        reverse(citations);
        
        //decsending order
        int i = 0;
        for (;i < citations.length; i++) {
            if (citations[i] <= i) { //citations[i] >= i + 1
                break;
            }
        }
        
        return i;
    }
    
    private void reverse(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = 0; 
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
