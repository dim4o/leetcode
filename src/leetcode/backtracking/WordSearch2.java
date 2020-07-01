// Given a 2D board and a list of words from the dictionary, find all words in the board.
// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" 
// cells are those horizontally or vertically neighboring. The same letter cell may not be used 
// more than once in a word.
// See: https://leetcode.com/problems/word-search-ii/
// See: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/

package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class WordSearch2 {
    private final int[][] directions = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    /**
     * Simple Backtracking implementation.
     * TODO: Use a Prefix Tree to optimize the queries.
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        for (String word : words)
            if (exist(board, word))
                ans.add(word);

        return ans;
    }

    private boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0) && backtrack(board, i, j, 0, word, used))
                    return true;

        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, int depth, String word,
            boolean[][] used) {
        if (depth == word.length())
            return true;

        if (board[i][j] == word.charAt(depth) && !used[i][j]) {
            if (word.length() == 1)
                return true;
            used[i][j] = true;
            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                    if (backtrack(board, newI, newJ, depth + 1, word, used))
                        return true;
                }
            }
            used[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch2 sln = new WordSearch2();
        char[][] board1 = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
        char[][] board2 = new char[][] { { 'a' } };
        char[][] board3 = new char[][] { { 'a', 'b' }, { 'a', 'a' } };

        System.out.println(sln.findWords(board1, new String[] { "oath", "pea", "eat", "rain" }));
        System.out.println(sln.findWords(board2, new String[] { "a" }));
        System.out.println(sln.findWords(board3, new String[] { "aaa", "aab", "baa", "aaaa" }));
    }

}
