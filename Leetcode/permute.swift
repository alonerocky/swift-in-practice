func permute(nums: [Int]) -> [[Int]] {
        if nums.count == 0 {
            return []
        }
        return permute(nums, 0, nums.count-1)
    }
    func permute(nums: [Int], _ start: Int, _ end: Int) -> [[Int]] {
        if start == end {
            return [[nums[start]]]
        }
        let first: Int = nums[start]
        var result_n_1 = permute(nums, start + 1, end)
        var result: [[Int]] = []
        for var permutation in result_n_1 {
            let count = permutation.count
            for i in 0 ... count {
                var per: [Int] = []
                per += permutation
                per.insert(first, atIndex: i)
                result.append(per)
            }
        }
        return result
    }
