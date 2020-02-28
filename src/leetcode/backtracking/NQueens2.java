// The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
// such that no two queens attack each other.
// Given an integer n, return the number of distinct solutions 
// to the n-queens puzzle.
// See: https://leetcode.com/problems/n-queens-ii/

package leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueens2 {
    private Set<Integer> rDiag = new HashSet<>();
    private Set<Integer> lDiag = new HashSet<>();
    private Set<Integer> hor = new HashSet<>();
    private Set<Integer> ver = new HashSet<>();

    private int ans = 0;

    public int totalNQueens(int n) {
        backtrack(n, 0);
        return ans;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isAvailable(row, col)) {
                // Mark all
                rDiag.add(row + col);
                lDiag.add(row - col);
                hor.add(row);
                ver.add(col);

                backtrack(n, row + 1);

                // Unmark all
                rDiag.remove(row + col);
                lDiag.remove(row - col);
                hor.remove(row);
                ver.remove(col);
            }
        }
    }

    private boolean isAvailable(int row, int col) {
        return !rDiag.contains(row + col) && !lDiag.contains(row - col) && !hor.contains(row) && !ver.contains(col);
    }

    public static void main(String[] args) {
        NQueens2 sln = new NQueens2();
        System.out.println(sln.totalNQueens(4));
    }

}
