public List<String> findStrobogrammatic(int n) {
         return helper(n, n);
    }
    
    public List<String> helper(int n, int total) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add("");
            return result;
        } else if (n == 1) {
            result.add("1");
            result.add("8");
            result.add("0");
            return result;
        } else {
            List<String> n_1 = helper(n-2, total);
            for(int i = 0; i < n_1.size(); i++) {
                String s = n_1.get(i);
                if (n != total) {
                    result.add("0" + s + "0" );
                }
                result.add("1" + s + "1" );
                result.add("8" + s + "8" );
                result.add("6" + s + "9" );
                result.add("9" + s + "6" );
            }
            return result;
        }
    }
