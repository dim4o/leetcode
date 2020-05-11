// Given two strings text1 and text2, return the length of their longest common subsequence.
// A subsequence of a string is a new string generated from the original string with some 
// characters(can be none) deleted without changing the relative order of the remaining characters. 
// (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings 
// is a subsequence that is common to both strings.
// If there is no common subsequence, return 0.
// See: https://leetcode.com/problems/longest-common-subsequence/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3311/

package leetcode.leetcode_challenge;

public class LongestCommonSubsequence {
    // Bottom-Up dynamic programming.
    // O(m.n) time, O(m.n) space
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        int[][] dp = new int[m][n];
        /**
         * It turns out that charAt(i) is slower here and it is worth to convert the
         * string to array of chars before performing heavy operation.
         */
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (ch1[i - 1] == ch2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    // Recursion with memorization: Top-Down dynamic programming.
    public int longestCommonSubsequence_var2(String text1, String text2) {
        return lcs2(text1, text2, 0, 0, new int[text1.length() + 1][text2.length() + 1]);
    }

    private int lcs2(String text1, String text2, int i, int j, int[][] memo) {
        if (i == text1.length() || j == text2.length())
            return 0;

        if (text1.charAt(i) == text2.charAt(j)) {
            if (memo[i + 1][j + 1] != 0)
                return memo[i + 1][j + 1] + 1;
            memo[i][j] = lcs2(text1, text2, i + 1, j + 1, memo) + 1;
            return memo[i][j];
        }
        int len1, len2;

        if (memo[i + 1][j] != 0)
            len1 = memo[i + 1][j];
        else
            len1 = lcs2(text1, text2, i + 1, j, memo);

        if (memo[i][j + 1] != 0)
            len2 = memo[i][j + 1];
        else
            len2 = lcs2(text1, text2, i, j + 1, memo);

        memo[i][j] = Math.max(len1, len2);

        return memo[i][j];
    }

    // Recursive approach: no accepted (TLE) bus looks concise and elegant.
    public int longestCommonSubsequence_var1(String text1, String text2) {
        return lcs1(text1.toCharArray(), text2.toCharArray(), 0, 0);
    }

    private int lcs1(char text1[], char[] text2, int i, int j) {
        if (i == text1.length || j == text2.length)
            return 0;

        if (text1[i] == text2[j])
            return lcs1(text1, text2, i + 1, j + 1) + 1;

        return Math.max(lcs1(text1, text2, i + 1, j), lcs1(text1, text2, i, j + 1));
    }

    public static void main(String[] args) {
        LongestCommonSubsequence sln = new LongestCommonSubsequence();

        System.out.println(sln.longestCommonSubsequence("abcde", "ace"));
        System.out.println(sln.longestCommonSubsequence("abc", "abc"));
        System.out.println(sln.longestCommonSubsequence("abc", "def"));
        System.out.println(sln.longestCommonSubsequence("abcde", "fce"));
        System.out.println(sln.longestCommonSubsequence("fce", "abcde "));
    }

}
