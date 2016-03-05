func summaryRanges(nums: [Int]) -> [String] {
    if nums.count == 0 {
        return []
    }
    var i: Int = 0
    var result: [String] = []
    while i < nums.count {
        var start: Int = i
        var end: Int = start + 1
        
        while end < nums.count && nums[end] == nums[end - 1] + 1 {
            end++
        }
        var range: String?
        if end - start == 1 {
            range = "\(nums[start])"
        } else {
            range = "\(nums[start])->\(nums[end-1])"
        }
        result.append(range!)
        
        i = end
    }
    
    return result
}
