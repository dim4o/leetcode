// Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
// You have the following 3 operations permitted on a word:
//     1. Insert a character
//     2. Delete a character
//     3. Replace a character
// See: https://leetcode.com/problems/edit-distance/

package leetcode.dp_and_recursion;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // printTable(dp);

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance sln = new EditDistance();

        System.out.println(sln.minDistance("", "")); // 3
        System.out.println(sln.minDistance("aba", "aba")); // 3
        System.out.println(sln.minDistance("horse", "ros")); // 3
        System.out.println(sln.minDistance("intention", "execution")); // 5
    }

    @SuppressWarnings("unused")
    private void printTable(int[][] dp) {
        for (int[] line : dp) {
            System.out.println(Arrays.toString(line));
        }
    }

}
