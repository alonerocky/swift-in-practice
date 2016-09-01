def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        a = sorted(s)
        b = sorted(t)
        l = len(s)
        i = 0
        while i in range(0, len(s)):
            if a[i] != b[i]:
                break
            i += 1
        return b[i]
