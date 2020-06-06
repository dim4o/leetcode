//Write a class StockSpanner which collects daily price quotes for some stock, and returns 
// the span of that stock's price for the current day.
// The span of the stock's price today is defined as the maximum number of consecutive days 
// (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
// For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], 
// then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
// See: https://leetcode.com/problems/online-stock-span/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
// See: https://leetcode.com/problems/online-stock-span/discuss/640569/Java-Two-solutions 

package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpan {
    /**
     * Solution 3: Stack.
     */
    class StockSpanner {
        private final Stack<int[]> stack = new Stack<>();;
        
        public int next(int price) {
            int span = 1;
            
            while (!stack.empty() && price >= stack.peek()[0])
                span += stack.pop()[1];
            
            stack.add(new int[] { price, span });
            return span;
        }
    }
    
    /**
     * Solution 2: Optimized version of Solution 1. The solution run faster bun still not faster enough.
     */
    class StockSpanner_var2 {
        private final List<int[]> prices = new ArrayList<>();
        
        public int next(int price) {
            int span = 1;
            int idx = prices.size() - 1;
            
            while (idx >= 0 && price >= prices.get(idx)[0]) {
                span += prices.get(idx)[1];
                idx = idx - prices.get(idx)[1];
            }

            prices.add(new int[] { price, span });
            return span;
        }
    }

    /**
     * Solution 1: Not optimal but very easy solution - accepted.
     */
    class StockSpanner_var1 {
        private final ArrayList<Integer> prices= new ArrayList<>();

        public int next(int price) {
            int span = 1;
            int idx = prices.size() - 1;
            while (idx >= 0 && price >= prices.get(idx--))
                span++;
            prices.add(price);
            return span;
        }
    }

    public static void main(String[] args) {
        StockSpanner sln = new OnlineStockSpan().new StockSpanner();
        System.out.println(sln.next(100)); // is called and returns 1,
        System.out.println(sln.next(80)); // is called and returns 1,
        System.out.println(sln.next(60)); // is called and returns 1,
        System.out.println(sln.next(70)); // is called and returns 2,
        System.out.println(sln.next(60)); // is called and returns 1,
        System.out.println(sln.next(75)); // is called and returns 4,
        System.out.println(sln.next(85)); // is called and returns 6.
    }

}
