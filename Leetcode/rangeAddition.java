public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0) {
            return new int[0];
        }
        int[] result = new int[length];
        if (updates == null || updates.length == 0 || updates[0].length == 0) {
            return result;
        }
        
        for(int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            result[start] += inc;
            if (end +1 < length) {
                result[end+1] -= inc;
            }
        }
        int presum = 0;
        
        for(int i = 0; i < length; i++) {
            presum += result[i];
            result[i] = presum;
        }
        return result;
    }
