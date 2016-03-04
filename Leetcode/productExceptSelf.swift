func productExceptSelf(nums: [Int]) -> [Int] {
    var prev: [Int] = [Int](count: nums.count, repeatedValue: 1)
    var post: [Int] = [Int](count: nums.count, repeatedValue: 1)
    
    for var i in 1 ..< nums.count {
        prev[i] = prev[i-1] * nums[i-1]
    }
    
    for var i = nums.count - 2; i >= 0; i-- {
        post[i] = post[i+1] * nums[i+1]
    }
    
    var result: [Int] = [Int](count: nums.count, repeatedValue: 1)
    for var i in 0 ..< nums.count {
        result[i] = prev[i] * post[i]
    }
    return result
}
