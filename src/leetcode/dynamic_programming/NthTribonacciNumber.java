// The Tribonacci sequence Tn is defined as follows: 
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
// Given n, return the value of Tn.
// See: https://leetcode.com/problems/n-th-tribonacci-number/

package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber {
    // Dynamic programming bottom-up implementation.
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        return dp[n];
    }
    
    // Dynamic programming - recursion with memorization, top-down implementation.
    private Map<Integer, Integer> memo = new HashMap<>();
    public int tribonacci_var2(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        
        if (!memo.containsKey(n - 1))
            memo.put(n - 1, tribonacci_var2(n - 1));
        
        if (!memo.containsKey(n - 2))
            memo.put(n - 2, tribonacci_var2(n - 2));
        
        if (!memo.containsKey(n - 3))
            memo.put(n - 3, tribonacci_var2(n - 3));
        
        return memo.get(n - 1) + memo.get(n - 2) + memo.get(n - 3);
    }
    
    // Plain recursion - not accepted (TLE)
    public int tribonacci_var(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        return tribonacci_var(n - 1) + tribonacci_var(n - 2) + tribonacci_var(n - 3);
    }

}
