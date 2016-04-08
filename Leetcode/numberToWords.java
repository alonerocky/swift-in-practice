private String[] NUM_WORDS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",
    "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private int[] WORDS_NUM = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90};

    private String[] NUM_WORDS_II = {"Thousand", "Million", "Billion"};
    private int[] WORDS_NUM_II = {1000, 1000000, 1000000000};
    public String numberToWords(int num) {
        StringBuffer sb = new StringBuffer();
        int len = NUM_WORDS_II.length;
        for (int i = len - 1; i >= 0; i--) {
            if (num >= WORDS_NUM_II[i]) {
                int thousand = num / WORDS_NUM_II[i];
                num = num % WORDS_NUM_II[i];
                sb.append(numberTowWordsLessThanThousand(thousand));
                sb.append(" ");
                sb.append(NUM_WORDS_II[i]);
                if (num != 0) {
                    sb.append(" ");
                }
            }
        }
        if (num != 0) {
            sb.append(numberTowWordsLessThanThousand(num));
        }
        if (sb.length() == 0) {
            return "Zero";
        }
        return sb.toString();
    }
    private String numberTowWordsLessThanThousand(int num) {
        StringBuffer sb = new StringBuffer();
        if (num >= 100) {
            sb.append(numberTowWordsLessThanHundred(num/100));
            sb.append(" Hundred");
            num = num % 100;
            if (num != 0) {
                sb.append(" ");
            }
        }
        sb.append(numberTowWordsLessThanHundred(num));
        return sb.toString();
    }
    private String numberTowWordsLessThanHundred(int num) {
        StringBuffer sb = new StringBuffer();
        int len = WORDS_NUM.length;
        for (int i = len - 1; i >= 0; i-- ) {

            if (num >= WORDS_NUM[i]) {
                sb.append(NUM_WORDS[i]);
                num -= WORDS_NUM[i];
                if (num != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
