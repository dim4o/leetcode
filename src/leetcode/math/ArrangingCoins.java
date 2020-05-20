// You have a total of n coins that you want to form in a staircase shape, 
// where every k-th row must have exactly k coins.
// Given n, find the total number of full staircase rows that can be formed.
// n is a non-negative integer and fits within the range of a 32-bit signed integer.
// See: https://leetcode.com/problems/arranging-coins/

package leetcode.math;

public class ArrangingCoins {
    
    // TODO: The problem can be done and with binary search. Think how.

    /**
     * Solution 2 - Pure Math
     */
    public int arrangeCoins(int n) {
        
        return (int)(Math.sqrt(1 + 8l*n) - 1)/2;
    }

    /**
     * Solution 1 - Initial bruteforce solution
     */
    public int arrangeCoins_var1(int n) {
        int i = 0;
        while (n - i > 0) n -= ++i;
        return i;
    }

    public static void main(String[] args) {
        ArrangingCoins sln = new ArrangingCoins();
        System.out.println(sln.arrangeCoins(5));
        System.out.println(sln.arrangeCoins(8));
        System.out.println(sln.arrangeCoins(1804289383));
    }

}
