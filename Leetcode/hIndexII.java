public int hIndexII(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
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
        int len = citations.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            int middle = (i+j)/2 ;
            if (len - middle <= citations[middle]) {
                j =  middle - 1;
            } else {
                i = middle + 1;
            }  
        }
        return len - i;
    }
