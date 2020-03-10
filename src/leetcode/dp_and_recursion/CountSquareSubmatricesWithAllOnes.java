// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
// See: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
// My explanation: https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/535076/Java-Fast-and-Concise-Solution-with-Explanations

package leetcode.dp_and_recursion;

import java.util.Arrays;

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] m) {
        int res = 0;
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1 && i > 0 && j > 0)
                    m[i][j] = Math.min(m[i - 1][j - 1], Math.min(m[i][j - 1], m[i - 1][j])) + 1;
                res += m[i][j];
            }

        return res;
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
        int[][] m2 = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };

        CountSquareSubmatricesWithAllOnes sln = new CountSquareSubmatricesWithAllOnes();

        System.out.println(sln.countSquares(m1));
        System.out.println(sln.countSquares(m2));

    }

    @SuppressWarnings("unused")
    private void printTable(int[][] dp) {
        for (int[] line : dp) {
            System.out.println(Arrays.toString(line));
        }
    }

}
