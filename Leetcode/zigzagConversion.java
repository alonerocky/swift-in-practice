private enum Direction {UP, DOWN}
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        
        StringBuffer[] strs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = new StringBuffer();
        }
        Direction d = Direction.DOWN;
        int row = 0;
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            strs[row].append(c);
            switch(d) {
                case UP:
                    if (row == 0) {
                        row++;
                        d = Direction.DOWN;
                    } else {
                        row--;
                    }
                    break;
                case DOWN:
                    
                    if (row == numRows -1) {
                        row--;
                        d = Direction.UP;
                    } else {
                        row++;
                    }
                    break;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i =0; i < numRows; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
