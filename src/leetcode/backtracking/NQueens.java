// The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
// such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle.
// See: https://leetcode.com/problems/n-queens/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    private Set<Integer> rDiag = new HashSet<>();
    private Set<Integer> lDiag = new HashSet<>();
    private Set<Integer> hor = new HashSet<>();
    private Set<Integer> ver = new HashSet<>();
    
    List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        backtrack(board, 0);
        
        return ans;
    }

    private void backtrack(int[][] board, int row) {
        if (row == board.length) {
            StringBuilder sb = new StringBuilder();
            List<String> result = new ArrayList<String>();
            for (int i = 0; i < board.length; i++) {
                sb.append("");
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                result.add(sb.toString());
                sb.setLength(0);
            }
            ans.add(result);

            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isAvailable(row, col)) {
                // Mark all
                rDiag.add(row + col);
                lDiag.add(row - col);
                hor.add(row);
                ver.add(col);
                board[row][col] = 1;

                backtrack(board, row + 1);

                // Unmark all
                rDiag.remove(row + col);
                lDiag.remove(row - col);
                hor.remove(row);
                ver.remove(col);
                board[row][col] = 0;
            } 
        }
    }
    
    private boolean isAvailable(int row, int col) {
        return !rDiag.contains(row + col) && !lDiag.contains(row - col) && !hor.contains(row) && !ver.contains(col);
    }

    public static void main(String[] args) {
        NQueens sln = new NQueens();
        System.out.println(sln.solveNQueens(4));

    }

    @SuppressWarnings("unused")
    private void printTable(int[][] dp) {
        for (int[] line : dp) {
            System.out.println(Arrays.toString(line));
        }
    }

}
