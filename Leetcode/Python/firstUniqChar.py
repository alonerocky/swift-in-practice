def firstUniqChar(s):
        """
        :type s: str
        :rtype: int
        """
        dic = {}
        for idx, ch in enumerate(s):
            if ch in dic:
                dic[ch].append(idx)
            else:
                dic[ch] = [idx]
        for idx, ch in enumerate(s):
            if len(dic[ch]) == 1:
                return idx
        return -1

print firstUniqChar('leetcode')
print firstUniqChar('loveleetcode')
