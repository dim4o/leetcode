// There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball 
// to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, 
// you can at most move N times. Find out the number of paths to move the ball out of grid boundary. 
// The answer may be very large, return it after mod 109 + 7.
// See: https://leetcode.com/problems/out-of-boundary-paths/

package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class OutOfBoundaryPaths {
    // TODO: Add Bottom-Up Dynamic Programming implementation

    /**
     * Solution 2 - Recursion with memorization, Top-down Dynamic Programming implementation (accepted).
     */
    public int findPaths(int m, int n, int N, int i, int j) {
        Map<String, Long> memo = new HashMap<>();
        return (int) (find(m, n, N, i, j, memo) % (1e9 + 7));
    }

    private long find(int m, int n, int N, int i, int j, Map<String, Long> memo) {
        if (N <= 0 && i >= 0 && j >= 0 && i < m && j < n)
            return 0;

        if (N >= 0 && (i < 0 || j < 0 || i == m || j == n))
            return 1;
        
        String key = N + "," + i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        long up = find(m, n, N - 1, i - 1, j, memo);
        long down = find(m, n, N - 1, i + 1, j, memo);
        long right = find(m, n, N - 1, i, j + 1, memo);
        long left = find(m, n, N - 1, i, j - 1, memo);

        long res = (long) ((up + down + right + left) % (1e9 + 7));
        
        memo.put(key, res);
        
        return res;
    }

    /**
     * Solution 1 - Very simple recursion - not accepted (TLE)
     */
    public int findPaths_(int m, int n, int N, int i, int j) {
        if (N <= 0 && i >= 0 && j >= 0 && i < m && j < n)
            return 0;

        if (N >= 0 && (i < 0 || j < 0 || i == m || j == n))
            return 1;

        int up = findPaths_(m, n, N - 1, i - 1, j);
        int down = findPaths_(m, n, N - 1, i + 1, j);
        int right = findPaths_(m, n, N - 1, i, j + 1);
        int left = findPaths_(m, n, N - 1, i, j - 1);
        return up + down + left + right;
    }

    public static void main(String[] args) {
        System.out.println(new OutOfBoundaryPaths().findPaths(1, 3, 3, 0, 1));
        System.out.println(new OutOfBoundaryPaths().findPaths(2, 2, 2, 0, 0));
    }
}
