// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
// See: https://leetcode.com/problems/surrounded-regions/
// See: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/

package leetcode.others;

public class SurroundedRegions {

    private final int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void solve(char[][] board) {
        if (board.length == 0) return;
        boolean[][] used = new boolean[board.length][board[0].length];
        
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O')
                dfs(0, j, board, used);
            
            if (board[board.length - 1][j] == 'O')
                dfs(board.length - 1, j, board, used);
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board, used);
        
            if (board[i][board[0].length - 1] == 'O')
                dfs(i, board[0].length - 1, board, used);
        }
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!used[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, char[][] board, boolean[][] used) {
        used[i][j] = true;
        for (int[] dir : directions) {
            int cI = dir[0] + i, cJ = dir[1] + j;
            if (cI >= 0 && cI < board.length && cJ >= 0 && cJ < board[0].length
                    && board[cI][cJ] == 'O' && !used[cI][cJ]) {
                dfs(cI, cJ, board, used);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sln = new SurroundedRegions();
        char[][] board = new char[][] {{'O','O','O',}, {'O','O','O',}, {'O','O','O',}};
        sln.solve(board);
        
    }

}
