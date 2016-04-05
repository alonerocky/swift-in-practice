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
