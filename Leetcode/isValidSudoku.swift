func isValidSudoku(board: [[Character]]) -> Bool {
    return isRowsValid(board) && isColumnsValid(board) && isBlockValid(board)
}

func isRowsValid(board: [[Character]]) -> Bool {
    let rows = board.count
    let columns = board[0].count
    for row in 0..<rows {
        var count: [Int] = [Int](count: 10, repeatedValue: 0)
        for column in 0..<columns {
            let ch = board[row][column]
            switch ch {
                case "1", "2","3","4","5","6","7","8","9":
                count[Int("\(ch)")! - 1]++
                if count[Int("\(ch)")! - 1] > 1 {
                    return false
                }
                case ".":
                    break
                //. do nothing
                default:
                return false
            }
        }
    }
    return true
    
}

func isColumnsValid(board: [[Character]]) -> Bool {
    let rows = board.count
    let columns = board[0].count
    for column in 0 ..< columns {
        var count: [Int] = [Int](count: 10, repeatedValue: 0)
        for row in 0 ..< rows {
            let ch = board[row][column]
            switch ch {
                case "1", "2","3","4","5","6","7","8","9":
                count[Int("\(ch)")! - 1]++
                if count[Int("\(ch)")! - 1] > 1 {
                    return false
                }
                case ".":
                    break
                default:
                return false
            }
        }
    }
    return true
}

func isBlockValid(board: [[Character]]) -> Bool {
    //9 blocks
    for row in 0 ..< 3 {
        for column in 0 ..< 3 {
            var count: [Int] = [Int](count: 10, repeatedValue: 0)
            for i in 0 ..< 3 {
                for j in 0 ..< 3 {
                    let ch = board[3 * row + i][3 * column + j]
                    if ch >= "0" && ch <= "9" {
                        count[Int("\(ch)")! - 1]++
                        if count[Int("\(ch)")! - 1] > 1 {
                            return false
                        }
                    } else if ch == "." {
                        //do nothing
                    } else {
                        return false
                    }
                }
            }
            
            
        }
    }
    return true
}

