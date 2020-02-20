// A robot is located at the top-left corner of a m x n grid 
// (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time.
// The robot is trying to reach the bottom-right corner of the grid
// (marked 'Finish' in the diagram below).
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// See: https://leetcode.com/problems/unique-paths-ii/

package leetcode.dp_and_recursion;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else 
                break;
        }
            
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else 
                break;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) 
                    if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] == 1) {
                        dp[i][j] = dp[i - 1][j];
                    } else if(obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
            }
        }
        
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePaths2 sln =new UniquePaths2();
        
        int[][] g1 = new int[3][7];
        g1[1][2] = 1;
        System.out.println(sln.uniquePathsWithObstacles(g1)); // 13
        
        g1[1][3] = 1;
        System.out.println(sln.uniquePathsWithObstacles(g1)); // 9
        
        int[][] g2 = new int[3][3];
        g2[1][1] = 1;
        System.out.println(sln.uniquePathsWithObstacles(g2)); // 2
        
        int[][] g3 = new int[][] {{1}};
        System.out.println(sln.uniquePathsWithObstacles(g3)); // 0
        
        int[][] g4 = new int[][] {{1, 0}};
        System.out.println(sln.uniquePathsWithObstacles(g4)); // 0
        
        int[][] g5 = new int[][] {{0, 1, 0}};
        System.out.println(sln.uniquePathsWithObstacles(g5)); // 0
        
    }

}
