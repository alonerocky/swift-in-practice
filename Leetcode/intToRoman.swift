func intToRoman(num: Int) -> String {
    var vNum = num
    let table: [Int: String] = [1: "I", 4: "IV", 5: "V", 9: "IX", 10: "X", 40: "XL", 50: "L", 90: "XC", 100: "C", 400: "CD", 500: "D", 900: "CM", 1000: "M"]
    let numTable = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
    var result = ""
    for key in numTable {
        let value = table[key]!
        while vNum >= key {
            result += value
            vNum -= key
        }
    }
    return result
}
