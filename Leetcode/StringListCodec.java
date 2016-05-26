public class Codec {

    // Encodes a list of strings to a single string.
    private static final char SPECIAL_CHAR = '#';
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        if (strs == null || strs.size() == 0) {
            return sb.toString();
        }
        for (int i =0; i < strs.size(); i++) {
            String str = strs.get(i);
            sb.append(str.length()).append(SPECIAL_CHAR).append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return strs;
        }
        int start = 0;
        int len = s.length();
        while (start < len) {
            int index = s.indexOf(SPECIAL_CHAR, start);
            int length = Integer.parseInt(s.substring(start, index));
            String str = s.substring(index+1, index+1+length);
            strs.add(str);
            start = index+1 + length;
        }
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));



public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
         if (strs == null || strs.size() == 0) {
             return sb.toString();
         }
         for (int i = 0; i < strs.size(); i++) {
             String str = strs.get(i);
             if (str == null) {
                 sb.append("NULL#");
             } else {
                 sb.append(str.length());
                 sb.append("#");
                 sb.append(str);
             }
         }
         return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
         if (s == null || s.length() == 0) {
             return result;
         }
         int i = 0;
         int len = s.length();
         while(i < len) {
             int index = s.indexOf('#', i);
             if (index == -1) {
                 break;
             }
             //[i, index) is the length
             String length = s.substring(i, index);
             if (length.equals("NULL")) {
                 result.add(null);
                 i = index+1;
             } else 
             {
                 int n = Integer.parseInt(length);
                 result.add(s.substring(index+1, index+1+n));
                 i = index+1+n;
             }
         }
         return result;
    }
