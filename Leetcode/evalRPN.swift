func evalRPN(tokens: [String]) -> Int {
    var stack: [Int] = []
    
    var result: Int = 0
    for token in tokens {
        switch token {
            case "+":
                var v2 = stack.popLast()
                var v1 = stack.popLast()
                if v1 != nil && v2 != nil {
                    stack.append(v1! + v2!)
            }
            case "-":
                var v2 = stack.popLast()
                var v1 = stack.popLast()
                if v1 != nil && v2 != nil {
                    stack.append(v1! - v2!)
            }
            case "*":
                    var v2 = stack.popLast()
                    var v1 = stack.popLast()
                    if v1 != nil && v2 != nil {
                        stack.append(v1! * v2!)
            }
            case "/":
                    var v2 = stack.popLast()
                    var v1 = stack.popLast()
                    if v1 != nil && v2 != nil {
                        stack.append(v1! / v2!)
            }
        default:
            stack.append(Int(token)!)
        }
    }
    return stack.popLast()!
}
