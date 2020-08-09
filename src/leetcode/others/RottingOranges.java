// In a given grid, each cell can have one of three values:
//
//  - the value 0 representing an empty cell;
//  - the value 1 representing a fresh orange;
//  - the value 2 representing a rotten orange.
//  - Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
//
// Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
// See: https://leetcode.com/problems/rotting-oranges/
// See: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/

package leetcode.others;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotingOrangesQ = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    rotingOrangesQ.add(new int[] { i, j });
                else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if (freshOranges == 0)
            return 0;

        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int steps = 0;

        while (!rotingOrangesQ.isEmpty()) {
            steps++;
            int len = rotingOrangesQ.size();
            for (int k = 0; k < len; k++) {
                int[] currOrange = rotingOrangesQ.poll();
                for (int[] dir : dirs) {
                    int I = currOrange[0] + dir[0], J = currOrange[1] + dir[1];
                    if (I >= 0 && I < grid.length && J >= 0 && J < grid[0].length
                            && grid[I][J] == 1) {
                        rotingOrangesQ.add(new int[] { I, J });
                        grid[I][J] = 2;
                        if (--freshOranges == 0)
                            return steps;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RottingOranges sln = new RottingOranges();
        System.out.println(sln.orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
        System.out.println(sln.orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
        System.out.println(sln.orangesRotting(new int[][] { { 0, 2 } }));
        System.out.println(sln.orangesRotting(new int[][] { { 2, 2, 2, 1, 1 } }));
    }

}
