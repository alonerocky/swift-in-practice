public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int m = s.length();
        int n = t.length();
        if (m == n) {
            return isOneModification(s, t);
        } else if (m == n + 1) {
            return isOneDeletion(s, t);
        } else if (m == n -1) {
            return isOneDeletion(t, s);
        } else {
            return false;
        }
    }
    public boolean isOneDeletion(String s, String t) {
        if (s.length() == t.length() + 1) {
            //s is one character longer
            int i = 0; 
            while (i < t.length() && s.charAt(i) == t.charAt(i)) {
                i++;
            }
            //i either point to end of t or point to the first element different
            return s.substring(i+1).equals(t.substring(i));
        }
        return false;
    }
    public boolean isOneModification(String s, String t) {
        int count = 0;
        if (s.length() == t.length()) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return count == 1;
        }
        return false;
    }
