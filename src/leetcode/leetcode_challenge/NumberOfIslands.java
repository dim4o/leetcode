// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.
// See: https://leetcode.com/problems/number-of-islands/
// See: https://leetcode.com/problems/number-of-islands/discuss/583559/Java-Very-Simple-DFS

package leetcode.leetcode_challenge;

import java.util.Arrays;

public class NumberOfIslands {
    private int[][] directions = new int[][] { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j);
                }
        return numOfIslands;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : directions) {
            int cI = dir[0] + i;
            int cJ = dir[1] + j;
            if (cI >= 0 && cI < grid.length && cJ >= 0 && cJ < grid[0].length && grid[cI][cJ] == '1')
                dfs(grid, cI, cJ);
        }
    }
    
    public static void main(String[] args) {
        NumberOfIslands sln = new NumberOfIslands();
        char[][] grid = new char[][] {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        
//        sln.dfs(grid, 0, 0);
        System.out.println(sln.numIslands(grid));
        
        for (char[] row : grid) System.out.println(Arrays.toString(row));

    }
    

}
