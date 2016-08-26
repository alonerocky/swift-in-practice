def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        mapping = {'I': 1, 'i' : 1, 'V' : 5, 'v': 5, 'X' : 10, 'x' : 10, 'L' : 50, 'l' : 50, 'C' : 100, 'c' : 100, 'D' : 500, 'd': 500, 'M' : 1000, 'm' : 1000}
        
        if s is None or len(s) == 0:
            return 0
        else:
            result = 0
            for i, c in enumerate(s):
                num, next = 0, 0
                if c in mapping:
                    num = mapping[c]
                if i < len(s) - 1:
                    next = mapping[s[i+1]]
                if (num < next):
                    result -= num
                else:
                    result += num
            
            return result
