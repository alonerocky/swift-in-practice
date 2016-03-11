public boolean isMatch(String s, String p) {
        if (p == null || s == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        int i =0; 
        char ch = p.charAt(0);
        if (ch == '?') {
            return s.length() > 0 && isMatch(s.substring(1), p.substring(1));
        } else if (ch == '*') {
            return isMatch(s, p.substring(1)) || s.length() > 0 && isMatch(s.substring(1), p);
        } else {
            return s.length() > 0 && s.charAt(0) == ch && isMatch(s.substring(1), p.substring(1));
        }
    }
/*
http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
         
        const char* star=NULL;
        const char* ss=s; 
        while (*s){
            if ((*p=='?')||(*p==*s)){s++;p++;continue;}
            if (*p=='*'){star=p++; ss=s;continue;}
            if (star){ p = star+1; s=++ss;continue;}
            return false;
        }
        while (*p=='*'){p++;}
        return !*p;
    }
};
*/
public boolean isMatch(String s, String p) {
        if(p == null || s == null)
            return false;
          
         if (p.length() == 0) {
             return s.length() == 0;
         }
         int sLen = s.length();
         int pLen = p.length();
         int i = 0;
         int j = 0;
         
         int pStar = -1;
         int sLast = -1;
         while (i < sLen) {
             if (j < pLen && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                 i++;
                 j++;
             } else if (j < pLen && p.charAt(j) == '*') {
                 pStar = j;
                 sLast = i;
                 j++; //try to matcch 0 from pattern
             } else if (pStar >= 0) {
                 j = pStar + 1;
                 i = sLast + 1;
                 sLast ++;
             } else {
                 return false;
             }
         }
         while (j < pLen && p.charAt(j) == '*') j++;
         return j == pLen;
    }