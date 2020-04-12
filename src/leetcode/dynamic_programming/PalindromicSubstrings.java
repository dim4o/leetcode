// Given a string, your task is to count how many palindromic substrings in this string.
// The substrings with different start indexes or end indexes are 
// counted as different substrings even they consist of same characters.
// See: https://leetcode.com/problems/palindromic-substrings/

package leetcode.dynamic_programming;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s.isEmpty())
            return 0;

        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            count += 1;
        }

        for (int i = 1; i < dp.length; i++)
            for (int j = 0; j < dp.length - i; j++)
                if (s.charAt(j) == s.charAt(j + i) && (dp[j + 1][j + i - 1] || i == 1)) {
                    dp[j][j + i] = true;
                    count += 1;
                }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings sln = new PalindromicSubstrings();
        System.out.println(sln.countSubstrings("abc"));
        System.out.println(sln.countSubstrings("aaa"));
    }

}
