func maxSubArray(nums: [Int]) -> Int {
    if nums.count == 0 {
        return 0
    }
    var maxNum: Int = nums[0]
    var current: Int = nums[0]
    for i in 1 ..< nums.count {
        if current < 0 {
             current = 0
        }
        current += nums[i]
        maxNum = max(maxNum, current)
    }
    return maxNum
}
