static public String leftPad(String originalStr, int size) {
        // Write your code here
        return leftPad(originalStr, size, ' ');
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        if (size <= 0) {
            return originalStr;
        }
        int len = originalStr == null ? 0 : originalStr.length();
        if (len > size) {
            return originalStr;
        }
        char[] chars = new char[size];
        Arrays.fill(chars, 0, size - len, padChar);
        if (len > 0) {
            System.arraycopy(originalStr.toCharArray(), 0, chars, size - len, len );
        }
        return new String(chars);
    }
