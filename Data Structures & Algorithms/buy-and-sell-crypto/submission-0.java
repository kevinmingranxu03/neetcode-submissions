class Solution {
    public int maxProfit(int[] prices) {
        int lower = prices[0];
        int higher = 0;
        int profit = 0;
        for (int price : prices) {
            if (price < lower) {
                lower = price;
                higher = lower;
            } else {
                higher = price;
            }
            profit = Math.max(higher - lower, profit);
        }
        return profit;
    }
}
