public class P309MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int rest = 0;
        int hold = -prices[0];
        int nonHold = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int rest0 = rest;
            int hold0 = hold;
            int nonHold0 = nonHold;
            rest = Math.max(rest0, nonHold0);
            hold = Math.max(rest0 - prices[i], hold0);
            nonHold = hold0 + prices[i];
        }
        return Math.max(rest, nonHold);
    }
}
