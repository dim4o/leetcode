// On a 2-dimensional grid, there are 4 types of squares:
//     1 represents the starting square.  There is exactly one starting square.
//     2 represents the ending square.  There is exactly one ending square.
//     0 represents empty squares we can walk over.
//     -1 represents obstacles that we cannot walk over.
// Return the number of 4-directional walks from the starting square to the ending 
// square, that walk over every non-obstacle square exactly once.
// See: https://leetcode.com/problems/unique-paths-iii/

package leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class UniquePaths3 {
    private int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int count = 0;
    private Set<Integer> used = new HashSet<>();

    public int uniquePathsIII(int[][] grid) {
        int sI = 0, sJ = 0;
        int freePos = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    freePos++;
                } else if (grid[i][j] == 1) {
                    sI = i;
                    sJ = j;
                }
            }
        }

        walk(grid, sI, sJ, freePos, 0);

        return count;
    }

    private void walk(int[][] grid, int sI, int sJ, int freePos, int pathLen) {
        if (grid[sI][sJ] == 2 && pathLen - 1 == freePos) {
            count++;
            return;
        }

        used.add(100*sI + sJ);
        
        for (int[] dir : directions) {
            int newI = sI + dir[0];
            int newJ = sJ + dir[1];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && 
                    newJ < grid[0].length && grid[newI][newJ] != -1
                    && !used.contains(100*newI + newJ)) {
                
                walk(grid, newI, newJ, freePos, pathLen + 1);
            }
            
        }
        
        used.remove(100*sI + sJ);
    }

    public static void main(String[] args) {
        int[][] g1 = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        int[][] g2 = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
        int[][] g3 = new int[][] { { 0, 1 }, { 2, 0 } };

        System.out.println(new UniquePaths3().uniquePathsIII(g1));
        System.out.println(new UniquePaths3().uniquePathsIII(g2));
        System.out.println(new UniquePaths3().uniquePathsIII(g3));
    }

}
