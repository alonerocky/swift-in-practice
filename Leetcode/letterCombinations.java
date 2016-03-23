private String[] mapping = {"", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        } else if (digits.length() == 1) {
            return mapOneChar(digits.charAt(0));
        } else {
            char c = digits.charAt(0);
            List<String> oneChar = mapOneChar(c);
            List<String> result_n_1 = letterCombinations(digits.substring(1));
            for (int i = 0; i < oneChar.size(); i++) {
                for (int j = 0; j < result_n_1.size();j++) {
                    String oneResult = result_n_1.get(j);
                    result.add(oneChar.get(i) + oneResult);
                }
            }
            return result;
        }
    }
    private List<String> mapOneChar(char c) {
        List<String> result = new ArrayList<String>();
        int digit = c - '0';
        String s = mapping[digit];
        char[] chars = s.toCharArray();
        for(int i =0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'a' && ch <= 'z') {
                result.add(""+ch);
            }
        }
        return result;
    }
