class Solution(object):
    def depthSum(self, nestedList):
        """
        :type nestedList: List[NestedInteger]
        :rtype: int
        """
        def depthSumHelper(nestedList, depth):
            sum = 0
            for num in nestedList:
                if num.isInteger():
                    sum += num.getInteger() * depth
                else:
                    sum += depthSumHelper(num.getList(), depth + 1)
            return sum
        return depthSumHelper(nestedList, 1)
