func canJump(nums: [Int]) -> Bool {
        if (nums.count == 0) {
            return false
        }
        
        var maxReach = 0
        var len = nums.count 
        for var i = 0; i <= maxReach; i++ {
            maxReach = max(maxReach, i + nums[i])
            if maxReach >= len - 1 {
                return true
            }
        }
        return false
    }
