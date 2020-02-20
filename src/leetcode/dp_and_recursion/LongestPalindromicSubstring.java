// Given a string s, find the longest palindromic substring in s. 
// You may assume that the maximum length of s is 1000.
// See: https://leetcode.com/problems/longest-palindromic-substring/

package leetcode.dp_and_recursion;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) 
            dp[i][i] = true;

        int start = 0;
        int maxLen = 1;
        for (int i = 1; i < dp.length; i++)
            for (int j = 0; j < dp.length - i; j++) 
                if (s.charAt(j) == s.charAt(j + i) && (dp[j + 1][j + i - 1] || i == 1)) {
                    dp[j][j + i] = true;
                    if (i + 1 > maxLen) {
                        maxLen = i + 1;
                        start = j;
                    }
                }


        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sln = new LongestPalindromicSubstring();

        System.out.println(sln.longestPalindrome("babad"));
        System.out.println(sln.longestPalindrome("cbbd"));
        System.out.println(sln.longestPalindrome("a"));
    }

}
