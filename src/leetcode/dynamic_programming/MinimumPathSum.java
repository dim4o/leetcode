package leetcode.dynamic_programming;

public class MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < n; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        
        for (int i = 1; i < m; i++) 
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        
        for (int i = 1; i < n; i++) 
            for (int j = 1; j < m; j++) 
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        
        return dp[n - 1][m - 1];
    }
    
    public static void main(String[] args) {
        MinimumPathSum sln = new MinimumPathSum();
        int[][] g1 = new int[][] { 
            { 1, 3, 1 }, 
            { 1, 5, 1 }, 
            { 4, 2, 1 } };
            
        System.out.println(sln.minPathSum(g1)); // 7
        System.out.println(sln.minPathSum(new int[][] {{1}})); // 1
        
    }
    
//    private void printGrid(int[][] grid) {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

}
