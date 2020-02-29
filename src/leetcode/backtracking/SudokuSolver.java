// Write a program to solve a Sudoku puzzle by filling the empty cells.
// See: https://leetcode.com/problems/sudoku-solver/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {
    // TODO: You may try to substitute the below maps with arrays for better performence
    private Map<Integer, Set<Character>> hMap = new HashMap<Integer, Set<Character>>();
    private Map<Integer, Set<Character>> vMap = new HashMap<Integer, Set<Character>>();
    private Map<Integer, Set<Character>> cMap = new HashMap<Integer, Set<Character>>();
    private List<int[]> positions = new ArrayList<>();
    private boolean found = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    Set<Character> hs = hMap.getOrDefault(i, new HashSet<>());
                    hs.add(curr);
                    hMap.put(i, hs);

                    Set<Character> vm = vMap.getOrDefault(j, new HashSet<>());
                    vm.add(curr);
                    vMap.put(j, vm);

                    int key = 10 * (i / 3) + (j / 3);
                    Set<Character> cs = cMap.getOrDefault(key, new HashSet<>());
                    cs.add(curr);
                    cMap.put(key, cs);
                } else {
                    positions.add(new int[] { i, j});
                }
            }
        }

        backtrack(board, 0);
//        printTable(board);
    }

    private void backtrack(char[][] board, int start) {
        if (start == positions.size()) {
//            printTable(board);
            found = true;
            return;
        }
        
        
        int row = positions.get(start)[0];
        int col = positions.get(start)[1];

        for (char i = '1'; i <= '9'; i++) {
            int key = 10 * ((row) / 3) + ((col) / 3);
            if (!hMap.getOrDefault(row, new HashSet<>()).contains(i) && 
                    !vMap.getOrDefault(col, new HashSet<>()).contains(i) && 
                    !cMap.getOrDefault(key, new HashSet<>()).contains(i)) {

                // Mark all
                board[row][col] = i;

                Set<Character> vs = vMap.getOrDefault(col, new HashSet<>());
                vs.add(i);
                vMap.put(col, vs);

                Set<Character> hs = hMap.getOrDefault(row, new HashSet<>());
                hs.add(i);
                hMap.put(row, hs);

                Set<Character> cs = cMap.getOrDefault(key, new HashSet<>());
                cs.add(i);
                cMap.put(key, cs);

                // call backtrack recursively

                backtrack(board, start + 1);

                if (!found) {
                    // unmark all
                    board[row][col] = '.';
                    hMap.get(row).remove(i);
                    vMap.get(col).remove(i);
                    cMap.get(key).remove(i);
                }

            }
        }
    }


    public static void main(String[] args) {
        SudokuSolver sln = new SudokuSolver();

        char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        sln.solveSudoku(board);

//        sln.printTable(board);

    }

    @SuppressWarnings("unused")
    private void printTable(char[][] dp) {
        for (char[] line : dp) {
            System.out.println(String.valueOf(line));
        }
    }

}
