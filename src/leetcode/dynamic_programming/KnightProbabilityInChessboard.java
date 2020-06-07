// On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. 
// The rows and columns are 0 indexed, so the top-left square is (0, 0), 
// and the bottom-right square is (N-1, N-1).
// A chess knight has 8 possible moves it can make, as illustrated below. 
// Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
// See: https://leetcode.com/problems/knight-probability-in-chessboard/

package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class KnightProbabilityInChessboard {
    // TODO: Add Bottom-Up Dynamic Programming.
    
    /**
     * Solution 1 - Top-Down Dynamic programming with memorization.
     */
    private int[][] movies = new int[][] { { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 }, { 1, -2 },
            { -1, -2 }, { 1, 2 }, { -1, 2 } };

    public double knightProbability(int N, int K, int r, int c) {
        return helper(N, K, r, c, new HashMap<>());
    }

    private double helper(int N, int K, int r, int c, Map<String, Double> memo) {
        if (r < 0 || c < 0 || r >= N || c >= N)
            return 0;
        if (K == 0)
            return 1;

        String key = K + "," + r + "," + c;
        if (memo.containsKey(key))
            return memo.get(key);

        double sum = 0;

        for (int[] mov : movies)
            sum += helper(N, K - 1, mov[0] + r, mov[1] + c, memo);
        sum *= 1d / 8;
        memo.put(key, sum);

        return sum;
    }

    public static void main(String[] args) {
        KnightProbabilityInChessboard sln = new KnightProbabilityInChessboard();
        System.out.println(sln.knightProbability(3, 2, 0, 0));
        System.out.println(sln.knightProbability(8, 30, 6, 4));
    }

}
