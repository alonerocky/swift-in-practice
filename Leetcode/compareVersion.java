public int compareVersion(String version1, String version2) throws NumberFormatException {
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            if (i < v1.length && i < v2.length) {
                int v1Num = Integer.parseInt(v1[i]);
                int v2Num = Integer.parseInt(v2[i]);
                if (v1Num < v2Num) {
                    return -1;
                } else if (v1Num > v2Num) {
                    return 1;
                } else {
                    i++;
                }
            } else if (i < v1.length) {
                if (Integer.parseInt(v1[i]) == 0) {
                    i++;
                } else {
                    return 1;
                }
            } else if (i < v2.length) {
                if (Integer.parseInt(v2[i]) == 0) {
                    i++;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }
