class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length <= 0)   {
            return profit;
        }
        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++)    {
            if(minPrice>prices[i])  {
                minPrice = prices[i];
            } else  {
                int currentDayProfit = prices[i] - minPrice;
                if(profit<currentDayProfit) {
                    profit = currentDayProfit;
                }
            }
        }
        return profit;
    }
}
