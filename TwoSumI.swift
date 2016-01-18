func twoSum(nums: [Int], _ target: Int) -> [Int] {
    var dict = [Int: [Int]]()
    var result = [-1, -1]
    
    for var index = 0; index < nums.count; index++ {
        
        if let _ = dict[nums[index]] {
            dict[nums[index]]!.append(index)
        } else {
            dict[nums[index]] = [index]
        }
    }
    
    for (key, _) in dict {
        
        let delta = target - key
        //found one
        if let indices = dict[delta] {
            if delta == key && indices.count >= 2{
                result = [indices[0] + 1, indices[1] + 1]
            } else if delta != key {
                result = dict[key]![0] < dict[delta]![0] ? [dict[key]![0] + 1, dict[delta]![0] + 1] : [dict[delta]![0] + 1, dict[key]![0] + 1]
            }
        }
    }
    return result
}

