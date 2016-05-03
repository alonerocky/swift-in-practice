public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        ArrayList<String> one = new ArrayList<String>();
        tryCut(s, 0, result, one );
        return result;
    }
    
    public void tryCut(String s, int i,List<List<String>> result, ArrayList<String> current ) {
        if (i == s.length() ) {
            result.add(new ArrayList<String>(current));
        } else if (i < s.length()) {
            for (int j = 1; i + j <= s.length(); j++ ) {
                
                String str = s.substring(i, i+j);
                if (isValid(str)) {
                    current.add(str);
                    tryCut(s, i+j, result, current);
                    current.remove(current.size()-1);
                }
                
            }
        }
        
        
    }
    
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i =0;
        int j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
