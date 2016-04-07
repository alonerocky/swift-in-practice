private String[] WORD_TABLE = {"Billion", "Million", "Thousand", "Hundred"};
    private int[]    NUM_TABLE  = {1000000000 , 1000000 , 1000 , 100 };
    private String[] WORD_BELOW_HUNDRED = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private int[]    NUMBER_BELOW_HUNDRED = {20, 30, 40, 50, 60, 70, 80, 90};
    private String[] NUMBER_BELOW_TWENTY = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        } else {
            StringBuffer sb = new StringBuffer();

            if (num >= 1000000000) {
                int a = num / 1000000000;
                num %= 1000000000;
                sb.append(numberToWordsLessThanThousand(a));
                sb.append(" Billion");
                if (num > 0) {
                    sb.append(" ");
                    sb.append(numberToWordLessThanBillion(num));
                }
                return sb.toString();
            } else {
                return numberToWordLessThanBillion(num);
            }
        }
    }

    //[0,  999,999,999]
    public String numberToWordLessThanBillion(int num) {
        StringBuffer sb = new StringBuffer();
        if (num >= 1000000) {
            int a = num / 1000000;
            num %= 1000000;
            sb.append(numberToWordsLessThanThousand(a));
            sb.append(" Million");
            if (num > 0) {
                sb.append(" ");
                sb.append(numberToWordLessThanMillion(num));
            }
            return sb.toString();
        } else {
            return numberToWordLessThanMillion(num);
        }
    }

    //[0, 999,999
    public String numberToWordLessThanMillion(int num) {
        StringBuffer sb = new StringBuffer();
        if (num >= 1000) {
            int a = num / 1000;
            num %= 1000;
            sb.append(numberToWordsLessThanThousand(a));
            sb.append(" Thousand");
            if (num != 0) {
                sb.append(" ");
                sb.append(numberToWordsLessThanThousand(num));
            }
            return sb.toString();
        } else {
            return numberToWordsLessThanThousand(num);
        }
    }

    //[0, 999]
    public String numberToWordsLessThanThousand(int num) {
        StringBuffer sb = new StringBuffer();
        if (num >= 100) {
            int a = num / 100;
            num %= 100;
            sb.append(numberToWordsLessThanHundred(a));
            sb.append(" Hundred");
            if (num != 0) {
                sb.append(" ");
                sb.append(numberToWordsLessThanHundred(num));
            }
            return sb.toString();
        } else {
            return numberToWordsLessThanHundred(num);
        }
    }

    /*
    num is number less than 100,  [0 - 99]
     */
    
    public String numberToWordsLessThanHundred(int num) {
        StringBuffer sb = new StringBuffer();
        if (num < 20) {
            return numberToWordsLessThanTwenty(num);
        }
        else if (num < 100) {
            int i = NUMBER_BELOW_HUNDRED.length - 1;
            while (i >= 0) {
                if (num >= NUMBER_BELOW_HUNDRED[i]) {
                    break;
                }
                i--;
            }
            sb.append(WORD_BELOW_HUNDRED[i]);
            num -= NUMBER_BELOW_HUNDRED[i];
            if (num > 0) {
                sb.append(" ");
                sb.append(numberToWordsLessThanTwenty(num));
            }
        }
        return sb.toString();
    }
    
    public String numberToWordsLessThanTwenty(int num) {
        if (num >= 0 && num < 20) {
            return NUMBER_BELOW_TWENTY[num];
        }
        return "";
    }
