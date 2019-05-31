public class P121MaxProfit {
    public int maxProfit(int[] prices) {
        int minBefore = Integer.MAX_VALUE;
        int result = 0;
        if (prices.length == 0) return result;
        for (int i : prices) {
            minBefore = Math.min(minBefore, i);
            result = Math.max(result, i - minBefore);
        }
        return result;
    }
}
