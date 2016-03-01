func maxProfit(prices: [Int]) -> Int {
    if prices.isEmpty {
        return 0
    }
    var maxValue: Int = 0
    var minNum: Int = prices[0]
    for var i = 1; i < prices.count; i++ {
        maxValue = max(maxValue, prices[i] - minNum)
        minNum = min(minNum, prices[i])
    }
    return maxValue
}

func maxProfit2(prices: [Int]) -> Int {
    if prices.isEmpty {
        return 0
    }
    var maxValue: Int = 0;
    var maxPrice: Int = prices[prices.count - 1]
    for var i = prices.count - 2; i >= 0 ; i-- {
        maxValue = max(maxValue, maxPrice - prices[i])
        maxPrice = max(maxPrice, prices[i])
    }
    return maxValue
}

