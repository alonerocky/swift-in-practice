public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        } else if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        } else {
            List<Integer> result_n_1 = grayCode(n-1);
            for(int i =0; i < result_n_1.size(); i++) {
                result.add(result_n_1.get(i));
            }
            for(int i = result_n_1.size() -1 ; i>= 0; i--) {
                int highBit = 1 << (n-1);
                result.add(highBit + result_n_1.get(i));
            }
            return result;
        }
    }
