// In a gold mine grid of size m * n, each cell in this mine has an integer 
// representing the amount of gold in that cell, 0 if it is empty.
// See: https://leetcode.com/problems/path-with-maximum-gold/

package leetcode.backtracking;

public class PathWithMaximumGold {
    private int[][] directions = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    private int maxGold = -1;
    
    public int getMaximumGold(int[][] grid) {
        boolean[][] used = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used[0].length; j++) {
                dfs(i, j, grid, used, 0);
            }
        }
        
        return maxGold;
    }
    
    private void dfs(int posI, int posJ, int[][] grid, boolean[][] used, int currGold) {
        maxGold = Math.max(maxGold, currGold);
        
        if (isAllowed(posI, posJ, grid, used)) {
            used[posI][posJ] = true;   

            for (int[] dir : directions) {
                int nextI = posI + dir[0];
                int nextJ = posJ + dir[1];
                dfs(nextI, nextJ, grid, used, currGold + grid[posI][posJ]);
            }
            
            used[posI][posJ] = false;
        }
    }
    
    private boolean isAllowed(int i, int j, int[][] grid, boolean used[][]) {
        int rows = grid.length;
        int cols = grid[0].length;
        return i >= 0 && i < rows && j >= 0 && j < cols && !used[i][j] && grid[i][j] != 0;
    }

    public static void main(String[] args) {
        int[][] g1 = new int[][] { 
            { 0, 6, 0 }, 
            { 5, 8, 7 }, 
            { 0, 9, 0 } };
        int[][] g2 = new int[][] { 
            { 1, 0, 7 }, 
            { 2, 0, 6 }, 
            { 3, 4, 5 }, 
            { 0, 3, 0 }, 
            { 9, 0, 20 } };
        
            System.out.println(new PathWithMaximumGold().getMaximumGold(g1));
            System.out.println(new PathWithMaximumGold().getMaximumGold(g2));
    }

}
