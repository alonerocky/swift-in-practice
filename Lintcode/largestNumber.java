public String largestNumber(int[] num) {
        // write your code here
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                 return (s2+s1).compareTo(s1+s2);
            }
        };
        if (num == null || num.length == 0) {
            return "0";
        }
        int len = num.length;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++) {
            strs[i] = String.valueOf(num[i]);
        }
        Arrays.sort(strs, comparator);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < num.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while(index < len && result.charAt(index) == '0') {
            index++;
        }
        if (index == len) {
            return "0";
        }
        return result.substring(index);
    }
