// Say you have an array for which the ith element is the price of a given stock on day i.
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
// (i.e., buy one and sell one share of the stock multiple times).
// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
// See: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

package leetcode.others;

public class BestTimeToBuyAndSellStockII {
    // TODO: Add an effective solution
    /**
     * Recursive solution - correct but not accepted due TLE.
     * For effective solution see: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
     */
    private int maxProfit = 0;

    public int maxProfit(int[] prices) {
        helper(prices, 0, true, false, 0);
        return maxProfit;
    }

    private void helper(int[] prices, int profit, boolean canBuy, boolean canSell, int pos) {
        if (pos == prices.length) {
            // System.out.println(profit);
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        if (canBuy && profit >= 0) {
            helper(prices, profit - prices[pos], false, true, pos + 1);
            helper(prices, profit, true, false, pos + 1);
        }

        if (canSell && profit + prices[pos] > 0) {
            helper(prices, profit + prices[pos], true, false, pos + 1);
            helper(prices, profit, false, true, pos + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new BestTimeToBuyAndSellStockII().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

}
