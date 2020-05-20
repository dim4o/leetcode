// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
// Note:
// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.
// See: https://leetcode.com/problems/word-break/

package leetcode.dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // TODO: Add iterative bottom-up DP solution
    
    /**
     * Simple recursion with memorization - accepted.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
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

    /**
     * Simple recursion - not accepted (TLE)
     */
    public boolean wordBreak_var1(String s, List<String> wordDict) {
        Set<String> wDict = new HashSet<>(wordDict);
        return recur1(s.toCharArray(), 0, "", wDict);
    }

    private boolean recur1(char[] sentence, int start, String curr, Set<String> wDict) {
        if (start == sentence.length)
            return wDict.contains(curr);

        boolean res = false;
        if (wDict.contains(curr))
            res = recur1(sentence, start + 1, "" + sentence[start], wDict);

        return res || recur1(sentence, start + 1, curr + sentence[start], wDict);
    }

    public static void main(String[] args) {
        WordBreak sln = new WordBreak();

        System.out
                .println(sln.wordBreak("leetcode", Arrays.asList(new String[] { "leet", "code" })));
        System.out.println(
                sln.wordBreak("applepenapple", Arrays.asList(new String[] { "apple", "pen" })));

        System.out.println(sln.wordBreak("catsandog",
                Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat" })));

        System.out.println(sln.wordBreak("aaaaaaa", Arrays.asList(new String[] { "aaaa", "aaa" })));
    }

}
