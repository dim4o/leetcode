// You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Note: Given n will be a positive integer.
// See:  https://leetcode.com/problems/climbing-stairs/

package leetcode.dynamic_programming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        return helper(n, new int[n + 1]);
    }

    private int helper(int n, int[] memo) {
        if (n < 4) return n;

        if (memo[n] == 0)
            memo[n] = helper(n - 1, memo) + helper(n - 2, memo);

        return memo[n];
    }

    public static void main(String... args) {
        ClimbingStairs sln = new ClimbingStairs();

        System.out.println(sln.climbStairs(1)); // 1
        System.out.println(sln.climbStairs(2)); // 2
        System.out.println(sln.climbStairs(3)); // 3
        System.out.println(sln.climbStairs(4)); // 5
        System.out.println(sln.climbStairs(5)); // 8
        System.out.println(sln.climbStairs(6)); // 13
        System.out.println(sln.climbStairs(7)); // 21
        System.out.println(sln.climbStairs(42)); // 433494437
        System.out.println(sln.climbStairs(44)); // 1134903170
    }
}
