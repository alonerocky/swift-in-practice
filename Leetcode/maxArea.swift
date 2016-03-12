func maxArea(height: [Int]) -> Int {
        if height.count == 0 {
            return 0
        }
        var result: Int = 0
        var i: Int = 0
        var j: Int = height.count - 1
        while i < j {
            let width: Int = j - i
            let high: Int = min(height[i], height[j])
            result = max(result, width * high)
            if height[i] <= height[j] {
                i++
            } else {
                j--
            }
        }
        return result
    }
