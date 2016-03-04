func merge(inout nums1: [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        //first append nums2 to end of nums1
        // nums1 [0...m-1][m...m+n-1]
        // nums  [0...n-1]
        if nums2.count == 0 {
            return
        }
        nums1[m...m+n-1] = nums2[0...n-1]
        //use merge sort idea
        let start: Int = 0
        let end: Int = m+n-1
        var middle: Int = m-1
        var left: Int = start
        var right: Int = middle+1
        while left <= middle && right <= end {
            if nums1[left] <= nums1[right] {
                left++
            } else {
                let temp: Int = nums1[right]
                //move nums[left...right-1] to nums1[left+1...right]
                nums1[left+1...right] = nums1[left...right-1]
                nums1[left] = temp
                left++
                right++
                middle++
            }
        }
    }
