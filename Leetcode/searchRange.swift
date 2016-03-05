func searchRange(nums: [Int], _ target: Int) -> [Int] {
    
    if (nums.count == 0) {
        return [-1, -1]
    }
    var low: Int = -1
    var high: Int = -1
    var i = 0
    var j = nums.count - 1
    while i < j {
        let middle: Int = (i + j) / 2
        if nums[middle] >= target {
            j = middle
        } else {
            i = middle + 1
        }
    }
    //now j point to the lower bound of range
    if nums[j] != target {
        return [-1, -1]
    }
    low = j
    i = j
    j = nums.count - 1
    while i < j {
        let middle: Int = (i + j) / 2 + 1
        if nums[middle] <= target {
            i = middle 
        } else {
            j = middle - 1
        }
    }
    high = i
    return [low, high]
}
