def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if s is None or t is None:
            return False
        elif len(s) != len(t):
            return False
        else:
            ls = list(s)
            lt = list(t)
            ls.sort()
            lt.sort()
            return ls == lt
