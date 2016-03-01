func setZeroes(inout matrix: [[Int]]) {
    let rows = matrix.count
    let columns = matrix[0].count
    var rowFlag = false
    var columnFlag = false
    for row in 0 ..< rows {
        if matrix[row][0] == 0 {
            columnFlag = true
            break
        }
    }
    for column in 0 ..< columns {
        if matrix[0][column] == 0 {
            rowFlag = true
            break
        }
    }
    
    for row in 0 ..< rows {
        for column in 0 ..< columns {
            if matrix[row][column] == 0 {
                matrix[row][0] = 0
                matrix[0][column] = 0
            }
        }
    }
    
    for row in 1 ..< rows {
        if matrix[row][0] == 0 {
            for column in 1 ..< columns {
                matrix[row][column] = 0
            }
        }
    }
    
    for column in 1 ..< columns {
        if matrix[0][column] == 0 {
            for row in 1 ..< rows {
                matrix[row][column] = 0
            }
        }
    }
    
    if rowFlag {
        for column in 0 ..< columns {
            matrix[0][column] = 0
        }
    }
    
    if columnFlag {
        for row in 0 ..< rows {
            matrix[row][0] = 0
        }
    }

