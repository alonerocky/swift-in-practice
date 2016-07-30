public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        result.add(word);
        dfs(word, 0, word.length(), result);
        return result;
    }
    
    public void dfs(String s, int index, int length, List<String> result) {
        for(int i = index; i < s.length(); i++) {
            for(int len = 1; len <= length && i + len <= s.length(); len++) {
                //replace [i,  i+len-1] with len
                StringBuffer sb = new StringBuffer(s);
                String lenStr = "" + len;
                sb.replace(i, i+len, lenStr);
                String newS = sb.toString();
                result.add(newS);
                int nextIndex = i + lenStr.length() + 1; // +1 to avoid two "len" adjacent together
                
                dfs(newS, nextIndex, length, result);
                
            }
        }
    }
