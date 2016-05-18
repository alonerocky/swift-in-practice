public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return result;
        }
        tryAddOperator(num, target, 0, 0, 0, "", result);
        return result;
    }

    public void tryAddOperator(String num, int target, int index, long prevNum, long currTotal, String currResult, List<String> result) {
        if (index == num.length() && currTotal == target) {
            result.add(currResult);
        } else if (index < num.length()) {
            for (int i = index+1; i <= num.length(); i++) {

                String nstr = num.substring(index, i);
                if (isValidNum(nstr)) {
                    long n = Long.parseLong(nstr);
                    if (currResult.length() == 0) {
                        tryAddOperator(num, target, i, n, n, nstr, result);
                    } else {

                        //*
                        tryAddOperator(num, target, i, prevNum * n, currTotal - prevNum + prevNum *n,currResult+"*"+nstr, result );

                        //+
                        tryAddOperator(num, target, i, n, currTotal + n, currResult+"+"+nstr, result);
                        //-
                        tryAddOperator(num, target, i, -n, currTotal - n, currResult+"-"+nstr, result);

                    }
                }
            }
        }
    }

    public boolean isValidNum(String num) {
        if (num.charAt(0) == '0' && num.length() > 1) {
            return false;
        }
        return true;
    }


///
