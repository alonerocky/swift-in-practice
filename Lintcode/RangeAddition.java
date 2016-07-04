public int[] getModifiedArrayI(int length, int[][] updates) {
        if (length <= 0) {
            return new int[0];
        }
        int[] result = new int[length];
        if (updates == null || updates.length == 0 || updates[0].length == 0) {
            return result;
        }
        int m = updates.length;
        for(int i = 0; i < m; i++) {
            int[] update = updates[i];
            int start = update[0];
            int end = update[1];
            int delta = update[2];
            if (start >= 0 && start < length && end >= start && end < length && delta != 0) {
                for(int j = start; j <= end; j++ ) {
                    result[j] += delta;
                }
            }
        }
        return result;
    }
    
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0) {
            return new int[0];
        }
        int[] result = new int[length];
        if (updates == null || updates.length == 0 || updates[0].length == 0) {
            return result;
        }
        int m = updates.length;
        for(int i = 0; i < m; i++) {
            int[] update = updates[i];
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            if (inc != 0 && start >= 0 && start < length && end >= start && end < length) {
                result[start] += inc;
                if (end +1 < length) {
                    result[end+1] -= inc;
                }
            }
            
        }
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
