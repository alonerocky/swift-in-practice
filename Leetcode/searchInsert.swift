func searchInsert(nums: [Int], _ target: Int) -> Int {
    if nums.count == 0 {
        return 0
    }
    var i: Int = 0
    var j: Int = nums.count - 1
    while i <= j {
        var median = ( i + j ) / 2
        var num = nums[median]
        if num == target {
            return median
        } else if (num < target) {
            i = median + 1
        } else {
            j = median - 1
        }
        
    }
    return i //i = j + 1
}
