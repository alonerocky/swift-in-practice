package Uber;

import java.util.*;

/**
 * Created by shoulongli on 5/19/16.
 */
public class Uber {

    public static void main(String[] argv) {
        /**
         * pattern = "abab", str = "redblueredblue" should return true.
         pattern = "aaaa", str = "asdasdasdasd" should return true.
         pattern = "aabb", str = "xyzabcxzyabc" should return false.
         */
        Uber u = new Uber();
        System.out.println(u.wordPatternMatch("abab", "redblueredblue") == true);
        System.out.println(u.wordPatternMatch("aaaa", "asdasdasdasd") == true);
        System.out.println(u.wordPatternMatch("aabb", "xyzabcxzyabc") == false);

        System.out.println(u.splitMessage("Hi Sivasrinivas,     your Uber is arriving now!", 25, true));
        System.out.println(u.splitMessage("one two three four five six seven eight nine", 15, false));

        System.out.println(u.myAtoi("    010"));
        u.treeMapTest();
    }

    public void treeMapTest() {

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(10, "v1");
        map.put(20, "v2");
        map.put(5, "v3");
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());
    }


    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        return tryMatch(str, 0, pattern, new ArrayList<String>());
    }

    public boolean tryMatch(String str, int index, String pattern, ArrayList<String> words) {
        if (index == str.length()) {
            return words.size() == pattern.length() && isValid(words, pattern);
        } else if (index < str.length() && words.size() < pattern.length()) {
            if (isValid(words, pattern)) {

                //split the words
                for (int i = index+1; i <= str.length();i++) {
                    String w = str.substring(index, i);
                    words.add(w);
                    if (words.size() <= pattern.length() && isValid(words, pattern)) {
                        if (tryMatch(str, i, pattern, words)) {
                            return true;
                        }
                    }
                    words.remove(words.size() -1);
                }
            }
        }
        return false;
    }

    public boolean isValid(ArrayList<String> words, String pattern) {

        if (words.size() > pattern.length()) {
            return false;
        }
        HashMap<Character, String> mapChar = new HashMap<Character, String>();
        HashMap<String, Character> mapWord = new HashMap<String, Character>();
        for (int i = 0; i < words.size(); i++) {
            char ch = pattern.charAt(i);
            String word = words.get(i);
            if (!mapChar.containsKey(ch)) {
                mapChar.put(ch, word);
            }
            if (!mapWord.containsKey(word)) {
                mapWord.put(word, ch);
            }

            if (ch != mapWord.get(word)) {
                return false;
            }
            if (!word.equals(mapChar.get(ch))) {
                return false;
            }

        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (t == null || s == null) {
            return "";
        }
        if (t.length() == 0) {
            return "";
        }

        int[] needToFind = new int[256];
        int[] found = new int[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needToFind[(int)c]++;
        }

        int minStart = 0;
        int minEnd = 0;
        int minLen = Integer.MAX_VALUE;
        boolean exist = false;
        int i = 0;
        int lenS = s.length();
        int len = 0;
        int j = 0;
        while(i < lenS) {

            char c = s.charAt(i);
            found[c]++;
            if (found[c] <= needToFind[c])
                len++;
            if (len == t.length()) {
                exist = true;
                while(j <= i && (needToFind[s.charAt(j)] == 0 || needToFind[s.charAt(j)] < found[s.charAt(j)] ) ) {
                    if (needToFind[s.charAt(j)] < found[s.charAt(j)]) {
                        found[s.charAt(j)]--;
                    }
                    j++;
                }
                if (i - j + 1 < minLen) {
                    minLen = i - j + 1;
                    minStart = j;
                    minEnd = i;
                }
            }
            i++;
        }
        if (exist) {
            return s.substring(minStart, minEnd + 1);
        } else {
            return "";
        }
    }


    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            String key = getKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        Iterator<ArrayList<String>> iterator = map.values().iterator();
        while(iterator.hasNext()) {
            ArrayList<String> one = iterator.next();
            Collections.sort(one);
            result.add(one);
        }
        return result;
    }

    public String getKey(String s) {
        if (s.length() == 0) {
            return s;
        }
        if (s.charAt(0) == 'a') {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        int delta = s.charAt(0) - 'a';
        char first = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= first ) {
                char ch = (char)(c - delta);
                sb.append(ch);
            } else {
                char ch = (char)(c + 26 - delta);
                sb.append(ch);
            }

        }
        return sb.toString();

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean found = false;
        int i =0;
        int j =0;
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;
        int len = s.length();
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(i < len) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                count++;
                while(j < i && count > 2) {
                    char ch = s.charAt(j);
                    if (map.get(ch) == 1) {
                        map.remove(ch);
                    } else {
                        map.put(ch, map.get(ch) - 1);
                    }
                    if (!map.containsKey(ch)) {
                        count--;
                    }
                    j++;
                }
            } else {
                map.put(c, map.get(c) + 1);
            }
            maxLen = Math.max(maxLen, i-j+1);

            i++;
        }
        return maxLen;
    }


    public List<String> splitMessage(String message, int limit, boolean includePaging) {
        List<String> result = new ArrayList<String> ();
        if (message == null || message.length() == 0 || limit <= 0) {
            return result;
        }



        String[] words = message.split("\\s+");
        int length = 0;

        int n = words.length;
        int i =0;
        int page = 1;

        while(i < n) {

            StringBuffer sb = new StringBuffer();
            sb.append(words[i]);
            int j = i + 1;
            int padding = 0;//
            if (includePaging) {// 5 + (int)Math.log10(page); {
               padding = 5 + (int)Math.log10(page);
            }
            while(j < n && sb.length() + words[j].length() + 1 <= limit - padding) {
                sb.append(" ");
                sb.append(words[j]);
                j++;
            }
            //sb.append(String.format("(%d/%d)", page, pages));
            result.add(sb.toString());
            if (j == n) {
                break;
            }
            page++;
            i = j;
        }
        for (int j =0 ;j < result.size();j++) {
            result.set(j, result.get(j) + String.format(" (%d/%d)", j+1, page));
        }

        return result;
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int len = str.length();
        int i = 0;
        while(i < len && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        boolean isNeg = false;
        char c = str.charAt(i);
        if (c == '+' || c == '-') {
            if (c == '-') {
                isNeg = true;
            }
            i++;
        }
        int result = 0;
        while(i < len) {
            char ch = str.charAt(i++);
            if (!Character.isDigit(ch)) {
                break;
            }
            int digit = ch - '0';

            if (isNeg) {
                if (-result < (Integer.MIN_VALUE + digit)/10) {
                    return Integer.MIN_VALUE;
                }

            } else {
                if (result > (Integer.MAX_VALUE - digit)/10) {
                    return Integer.MAX_VALUE;
                }
            }
            result = result * 10 + digit;
        }
        if (isNeg) {
            return -result;
        } else {
            return result;
        }


    }


}
