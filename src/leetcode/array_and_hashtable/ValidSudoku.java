// Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according 
// to the following rules:
//   - Each row must contain the digits 1-9 without repetition.
//   - Each column must contain the digits 1-9 without repetition.
//   - Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// See: https://leetcode.com/problems/valid-sudoku/

package leetcode.array_and_hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> sqMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    Set<Character> s1 = rowMap.getOrDefault(i, new HashSet<>());
                    if (!s1.contains(board[i][j]))
                        s1.add(board[i][j]);
                    else
                        return false;
                    rowMap.put(i, s1);

                    Set<Character> s2 = colMap.getOrDefault(j, new HashSet<>());
                    if (!s2.contains(board[i][j]))
                        s2.add(board[i][j]);
                    else
                        return false;
                    colMap.put(j, s2);

                    Set<Character> s3 = sqMap.getOrDefault(i / 3 + 10 * (j / 3), new HashSet<>());
                    if (!s3.contains(board[i][j]))
                        s3.add(board[i][j]);
                    else
                        return false;
                    sqMap.put(i / 3 + 10 * (j / 3), s3);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku sln = new ValidSudoku();
        System.out.println(
                sln.isValidSudoku(new char[][] { 
                        { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                        { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));

    }

}
