public int maxProfitI(int[] prices) {
        int max = 0;
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return max;
    }
    
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i>=0; i--) {
            max = Math.max(max, maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        return max;
    }
