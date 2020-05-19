// Given a list of strings words representing an English Dictionary, find the longest word in words 
// that can be built one character at a time by other words in words. If there is more than one possible answer, 
// return the longest word with the smallest lexicographical order.
// If there is no answer, return the empty string.
// See: https://leetcode.com/problems/longest-word-in-dictionary/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestWordInDictionary {

    // TODO: Add solution with Trie!

    /**
     * Easy solution with sorting - Accepted.
     */
    public String longestWord(String[] words) {
        List<String> W = Arrays.asList(words);
        Collections.sort(W, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        Set<String> set = new HashSet<>(W);
        for (String word : W) {
            String curr = "";
            for (char ch : word.toCharArray())
                if (!set.contains(curr += ch))
                    break;
            if (word.length() == curr.length())
                return curr;
        }

        return "";
    }

    public static void main(String[] args) {
        LongestWordInDictionary sln = new LongestWordInDictionary();
        System.out.println(sln.longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
        System.out.println(sln.longestWord(
                new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
        System.out.println(sln.longestWord(new String[] { "k", "lg", "it", "oidd", "oid", "oiddm",
                "kfk", "y", "mw", "kf", "l", "o", "mwaqz", "oi", "ych", "m", "mwa" }));
    }

}
