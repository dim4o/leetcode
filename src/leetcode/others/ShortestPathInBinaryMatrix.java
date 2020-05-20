// In an N by N square grid, each cell is either empty (0) or blocked (1).
// Return the length of the shortest such clear path from top-left to bottom-right.  
// If such a path does not exist, return -1.
// See: https://leetcode.com/problems/shortest-path-in-binary-matrix/

package leetcode.others;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    /**
     * There is a performance trap here and can be applied to all BFS algorithms!
     * The cell should not be marked as visited before to traverse the directions!
     * The sell should be marked is visited right before/after adding to the queue!
     * Otherwise some of the cells will be added to the queue multiple times. The
     * algorithm still will work correctly but with terrible performance.
     * CONCLUSION: All nodes in the queue should be marked as visited.
     */
    private final int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 },
            { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1)
            return -1;

        if (grid.length == 1 && grid[0].length == 1)
            return 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1 });
        grid[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // Mark as visited should not be here!
            // grid[curr[0]][curr[1]] = -1;

            for (int[] dir : directions) {
                int newI = curr[0] + dir[0];
                int newJ = curr[1] + dir[1];
                if (newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid.length
                        && grid[newI][newJ] == 0) {
                    if (newI == grid.length - 1 && newJ == grid.length - 1)
                        return curr[2] + 1;
                    queue.add(new int[] { newI, newJ, curr[2] + 1 });
                    grid[newI][newJ] = -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix sln = new ShortestPathInBinaryMatrix();
        System.out.println(sln.shortestPathBinaryMatrix(new int[][] { { 0 } }));
        System.out.println(sln.shortestPathBinaryMatrix(new int[][] { { 0, 1 }, { 1, 0 } }));
        System.out.println(sln
                .shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));

    }

}
