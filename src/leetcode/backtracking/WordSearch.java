// Given a 2D board and a word, find if the word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cell, 
// where "adjacent" cells are those horizontally or vertically neighboring. 
// The same letter cell may not be used more than once.
// See: https://leetcode.com/problems/word-search/submissions/

package leetcode.backtracking;

public class WordSearch {
    private int[][] directions = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    private boolean pathExist = false;

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[0].length; j++) 
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, i, j, 0, word, used);
                }
                if (pathExist) return true;

        return pathExist;
    }

    private void dfs(char[][] board, int i, int j, int depth, String word, boolean[][] used) {
        if (!pathExist && !used[i][j] && depth <= word.length() && board[i][j] == word.charAt(depth)) {
            if (depth == word.length() - 1 && board[i][j] == word.charAt(depth)) {
                pathExist = true;
            } else {
                used[i][j] = true;
                for (int[] dir : directions) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                        dfs(board, newI, newJ, depth + 1, word, used);
                    }
                }
                used[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(new WordSearch().exist(board, "ABCCED") == true);
        System.out.println(new WordSearch().exist(board, "ASA") == true);
        System.out.println(new WordSearch().exist(board, "ASAC") == false);
        System.out.println(new WordSearch().exist(board, "AC") == false);
        System.out.println(new WordSearch().exist(board, "ASFBCCC") == false);
        System.out.println();
        System.out.println(new WordSearch().exist(board, "SEE") == true);
        System.out.println(new WordSearch().exist(board, "ABCB") == false);
        System.out.println(new WordSearch().exist(new char[][] { { 'a' } }, "a") == true);
    }

}
