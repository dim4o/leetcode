// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
// Note:
//   - The same word in the dictionary may be reused multiple times in the segmentation.
//   - You may assume the dictionary does not contain duplicate words.
// See: https://leetcode.com/problems/word-break-ii/
// See: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/

package leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
    /**
     * Backtracking solution + memorization.
     * TODO: Try to find cleaner solution.
     */
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (!canBreak(s, wordDict))
            return res;

        backtrack(s, "", "", 0, new HashSet<>(wordDict));
        return res;
    }

    private void backtrack(String s, String currWord, String currRes, int pos, Set<String> dict) {
        if (pos == s.length()) {
            if (currWord.isEmpty())
                res.add(currRes.trim());
            return;
        }

        String newWord = currWord + s.charAt(pos);

        if (dict.contains(newWord)) {
            res.add(newWord);
            backtrack(s, "", currRes + " " + newWord, pos + 1, dict);
            res.remove(newWord);
        }

        backtrack(s, newWord, currRes, pos + 1, dict);
    }

    /**
     * Checks whether the string is breakable.
     */
    public boolean canBreak(String s, List<String> wordDict) {
        Set<String> wDict = new HashSet<>(wordDict);
        int[] memo = new int[s.length() + 1];
        return recur(s.toCharArray(), 0, "", wDict, memo);
    }

    private boolean recur(char[] sentence, int start, String curr, Set<String> wDict, int[] memo) {
        if (start == sentence.length)
            return wDict.contains(curr);

        boolean res = false;
        if (wDict.contains(curr)) {
            if (memo[start + 1] == 0) {
                res = recur(sentence, start + 1, "" + sentence[start], wDict, memo);
                memo[start + 1] = res == true ? 1 : -1;
            } else
                res = memo[start + 1] == 1 ? true : false;
        }

        return res || recur(sentence, start + 1, curr + sentence[start], wDict, memo);
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak2().wordBreak("catsanddog",
                List.of("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreak2().wordBreak("pineapplepenapple",
                List.of("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(new WordBreak2().wordBreak("catsandog",
                List.of("cats", "dog", "sand", "and", "cat")));

        System.out.println(new WordBreak2().wordBreak("".repeat(75) + "b" + "".repeat(75),
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
                        "aaaaaaaaa", "aaaaaaaaaa")));
    }

}
