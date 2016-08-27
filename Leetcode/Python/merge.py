class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        if nums2 is None or len(nums2) == 0:
            return
        
        if m == 0:
            nums1[0:n] = nums2[0:n]
            
        if nums2[0] >= nums1[m-1]:
            nums1[m:m+n] = nums2[0:n]
        else:
            i, j, k = m - 1, n - 1, m + n -1
            while i >= 0 and j >= 0:
                if nums1[i] >= nums2[j]:
                    nums1[k], k, i = nums1[i], k - 1, i - 1
                else:
                    nums1[k], k, j = nums2[j], k - 1, j - 1
            
            if j >= 0:
                nums1[0:j+1] = nums2[0:j+1]
