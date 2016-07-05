public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 2) {
            return result;
        }
        int i = 0;
        while (i < s.length() - 1) {
            //[i,i+1] == "++"
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+' ) {
                StringBuffer sb = new StringBuffer();
                sb.append(s.substring(0,i));//[0,i-1]
                sb.append("--");
                sb.append(s.substring(i+2));
                result.add(sb.toString());
            }
            i++;
        }
        return result;
    }
