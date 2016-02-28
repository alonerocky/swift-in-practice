func searchMatrix(matrix: [[Int]], _ target: Int) -> Bool {
    let rows = matrix.count
    let columns = matrix[0].count
    if target < matrix[0][0] || target > matrix[rows - 1][columns - 1] {
        return false
    }
    
    var i = 0
    var j = columns - 1
    while i < rows && j >= 0 {
        if target == matrix[i][j] {
            return true
        } else if target < matrix[i][j] {
            j--
        } else {
            i++
        }
    }
    return false
}

