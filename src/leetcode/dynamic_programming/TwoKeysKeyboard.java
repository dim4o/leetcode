// Initially on a notepad only one character 'A' is present. 
// You can perform two operations on this notepad for each step:
//     1. Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
//     2. Paste: You can paste the characters which are copied last time.
// Given a number n. You have to get exactly n 'A' on the notepad by performing 
// the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
// See: https://leetcode.com/problems/2-keys-keyboard/submissions/

package leetcode.dynamic_programming;

public class TwoKeysKeyboard {
    // Actually the minimum steps are the sum of the prime factorization of n
    public int minSteps(int n) {
        if (n == 1) return 0;
        int ans = 0;
        int len = n / 2;
        for (int i = 2; i <= len; i++) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        // if ans == 0 => n is prime => return n
        return ans == 0 ? n : ans;
    }

    // Not optimal but working solution
    public int minSteps1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++)
            dp[i] = i;

        for (int i = 1; i < dp.length; i++) {
            int len = (int) Math.sqrt(i);
            for (int j = 2; j <= len; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        TwoKeysKeyboard sln = new TwoKeysKeyboard();
        System.out.println(sln.minSteps(1));
        System.out.println(sln.minSteps(5));
        System.out.println(sln.minSteps(16));
        System.out.println(sln.minSteps(24));
        System.out.println(sln.minSteps(48));

    }

}
