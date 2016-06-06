public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) {
            return result;
        }
        //put all the reversed word into hashmap

        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversed = reverse(word);
            if (!map.containsKey(reversed)) {
                map.put(reversed, new ArrayList<Integer>());
            }
            map.get(reversed).add(i);
        }
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        //get all prefix and postfix
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length();j++) {
                String prefix = word.substring(0, j);
                String postfix = word.substring(j);
                if (map.containsKey(prefix) && isPalindrome(postfix)) {
                    if (map.get(prefix).get(0) != i) {
                        ArrayList<Integer> oneResult = new ArrayList<Integer>();
                        oneResult.add(i);
                        oneResult.add(map.get(prefix).get(0));
                        if(set.add(oneResult)) {
                            result.add(oneResult);
                        }
                    }
                }
            }

            for(int j = 0; j <= word.length();j++) {
                String postfix = word.substring(j);
                String prefix = word.substring(0, j);
                if (map.containsKey(postfix) && isPalindrome(prefix)) {
                    if (map.get(postfix).get(0) != i) {
                        ArrayList<Integer> oneResult = new ArrayList<Integer>();
                        oneResult.add(map.get(postfix).get(0));
                        oneResult.add(i);
                        if(set.add(oneResult)) {
                            result.add(oneResult);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
               return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public String reverse(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = s.length() - 1; i>= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
