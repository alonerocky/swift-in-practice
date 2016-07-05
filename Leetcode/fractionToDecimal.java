public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();

        if (numerator == 0) {
            return "0";
        } else if (denominator == 0) {
            return "";
        }
        long m = numerator;
        long n = denominator;
        boolean isNeg = numerator < 0;
        if (denominator < 0) {
            isNeg = !isNeg;
        }

        if(isNeg) {
            sb.append("-");
        }

        m = Math.abs(m);
        n = Math.abs(n);

        long a = m/n;
        long b = m % n;
        sb.append(a);
        if (b != 0) {
            sb.append(".");
            b *= 10;
            //remining, start of looping
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            while(b != 0) {

                if (map.containsKey(b)) {
                    String result = sb.toString();
                    String first = result.substring(0, map.get(b));
                    String second = result.substring(map.get(b));
                    StringBuffer r = new StringBuffer();
                    r.append(first).append("(").append(second).append(")");
                    return r.toString();
                } else {
                    map.put(b, sb.length() );
                    sb.append(b/n);
                    b = b % n;
                    b *= 10;
                }
            }
        }

        return sb.toString();
    }
