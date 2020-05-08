// See: https://leetcode.com/problems/game-of-life/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameOfLife {
    /**
     * Initial solution(accepted).
     */
    public void gameOfLife(int[][] board) {
        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;

                for (int p = i - 1; p < i + 2; p++) {
                    for (int q = j - 1; q < j + 2; q++) {
                        if (p >= 0 && q >= 0 && p < board.length && q < board[0].length
                                && (p != i || q != j) && board[p][q] == 1) {
                            count++;
                        }
                    }
                }

                map.put(new int[] { i, j }, count);
            }
        }

        for (int[] key : map.keySet()) {
            int count = map.get(key);
            int i = key[0];
            int j = key[1];
            if (count < 2 && board[i][j] == 1) {
                board[i][j] = 0;
            } else if ((count == 3 || count == 2) && board[i][j] == 1) {
                board[i][j] = 1;
            } else if (count > 3 && board[i][j] == 1) {
                board[i][j] = 0;
            } else if (count == 3 && board[i][j] == 0) {
                board[i][j] = 1;
            }
        }

//        System.out.println(map);

    }

    public static void main(String[] args) {
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

        GameOfLife sln = new GameOfLife();
        sln.gameOfLife(board);

        for (int[] row : board)
            System.out.println(Arrays.toString(row));

    }

}
