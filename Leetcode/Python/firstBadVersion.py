def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        i,j = 1, n
        while i <= j:
            middle = (i + j)/2
            if isBadVersion(middle):
                j = middle - 1
            else:
                i = middle + 1
        return i
