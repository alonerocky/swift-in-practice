func isValid(s: String) -> Bool {
    var stack: [Character] = []
    for ch in s.characters {
        switch ch {
            case "(":
                fallthrough
            case "[":
                fallthrough
            case "{":
                stack.append(ch)
            case ")":
                if !stack.isEmpty && stack.last! == "(" {
                    stack.popLast()
                } else {
                    return false
            }
            case "]":
                if !stack.isEmpty && stack.last! == "[" {
                    stack.popLast()
                } else {
                    return false
            }
            case "}":
                if !stack.isEmpty && stack.last! == "{" {
                    stack.popLast()
                } else {
                    return false
            }
            
        default:
            return false
        }
    }
    return stack.isEmpty
}

