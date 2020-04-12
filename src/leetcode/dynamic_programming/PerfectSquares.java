// Given a positive integer n, find the least number of perfect square numbers 
// (for example, 1, 4, 9, 16, ...) which sum to n.
// See: https://leetcode.com/problems/perfect-squares/

package leetcode.dynamic_programming;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            int up = (int) Math.sqrt(i) + 1;
            for (int j = 1; j < up; j++)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares sln = new PerfectSquares();
        System.out.println(sln.numSquares(1));
        System.out.println(sln.numSquares(2));
        System.out.println(sln.numSquares(3));
        System.out.println(sln.numSquares(4));
        System.out.println(sln.numSquares(5));
        System.out.println(sln.numSquares(6) == 3);
        System.out.println(sln.numSquares(7) == 4);
        System.out.println(sln.numSquares(8) == 2);
        System.out.println(sln.numSquares(9) == 1);
        System.out.println(sln.numSquares(10) == 2);
        System.out.println(sln.numSquares(11) == 3);
        System.out.println(sln.numSquares(12));
        System.out.println(sln.numSquares(13) == 2);
        System.out.println(sln.numSquares(14) == 3);
        System.out.println(sln.numSquares(15) == 4);
        System.out.println(sln.numSquares(16) == 1);
        System.out.println(sln.numSquares(48));
    }

}
