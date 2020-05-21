// Given a string s, find the longest palindromic subsequence's length in s. 
// You may assume that the maximum length of s is 1000.
// See: https://leetcode.com/problems/longest-palindromic-subsequence/

package leetcode.dynamic_programming;

public class LongestPalindromicSubsequence {
    /**
     * Solution 3: Top-down DP recursive implementation.
     */
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return lps(s.toCharArray(), 0, s.length() - 1, memo);
    }
    
    private int lps(char[] S, int i, int j, int[][] memo) {
        if (i > j) 
            return 0;
        if (i == j)
            return 1;
        
        if (S[i] == S[j]) {
            if (memo[i+1][j-1] == 0)
                memo[i+1][j-1] = lps(S, i + 1, j - 1, memo);
            return memo[i+1][j-1] + 2;
        }
        
        if (memo[i + 1][j] == 0) 
            memo[i + 1][j] = lps(S, i + 1, j, memo);
        
        if (memo[i][j - 1] == 0) 
            memo[i][j - 1] = lps(S, i, j - 1, memo);
        
        return Math.max(memo[i + 1][j], memo[i][j - 1]);
        
    }
    
    /**
     * Solution 2: Bottom-Up DP iterative implementation.
     * Same as Solution 1 but slightly more concise.
     */
    public int longestPalindromeSubseq_var2(String s) {
        char[] S = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) dp[i][i] = 1;

        for (int currLen = 1; currLen < S.length; currLen++)
            for (int i = 0, j = currLen + i; j < S.length; i++, j++)
                dp[i][j] = S[i] == S[j] ? dp[i + 1][j - 1] + 2 : Math.max(dp[i + 1][j], dp[i][j - 1]);
        
        return dp[0][s.length() - 1];
    }
    
    /**
     * Solution 1 : Bottom-Up DP iterative implementation
     */
    public int longestPalindromeSubseq_var1(String s) {
        char[] S = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++)
            dp[i][i] = 1;

        for (int currLen = 1; currLen < S.length; currLen++) {
            int i = 0;
            int j = currLen;
            while (i < S.length && j < S.length) {
                if (S[i] == S[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                i++; j++;
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence sln = new LongestPalindromicSubsequence();
        System.out.println(sln.longestPalindromeSubseq("bbbab")); // 4
        System.out.println(sln.longestPalindromeSubseq("labcbfa")); // 5
        System.out.println(sln.longestPalindromeSubseq("cbbd")); // 2
        
        System.out.println(sln.longestPalindromeSubseq("aaaa")); // 4
        
        // f(a)g(b)h(c)(i)(c)k(b)l(a)
        System.out.println(sln.longestPalindromeSubseq("fagbhcickbla")); // 7
        
        // f(a)g(b)h(c)(c)k(b)l(a)
        System.out.println(sln.longestPalindromeSubseq("fagbhcckbla")); // 6

    }

}
