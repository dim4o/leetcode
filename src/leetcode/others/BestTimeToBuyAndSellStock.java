// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
// design an algorithm to find the maximum profit.
// Note that you cannot sell a stock before you buy one.
// See: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package leetcode.others;

public class BestTimeToBuyAndSellStock {
    // One pass solution
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - prices[minIdx]);
            
            if (prices[i] < min) {
                min = prices[i];
                minIdx = i;
            }
        }

        return maxProfit;
    }

    // Brute force approach - Accepted but slow solution.
    public int maxProfit_var1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sln = new BestTimeToBuyAndSellStock();
        System.out.println(sln.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(sln.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        System.out.println(sln.maxProfit(new int[] { 2, 1, 2, 1, 0, 1, 2 }));

    }

}
