// A happy string is a string that:
//   - consists only of letters of the set ['a', 'b', 'c'].
//   - s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
// For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings 
// "aa", "baa" and "ababbc" are not happy strings.
// Given two integers n and k, consider a list of all happy strings of length n 
// sorted in lexicographical order.
// Return the kth string of this list or return an empty string if there are 
// less than k happy strings of length n.
// See: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
// See: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/discuss/614867/Java-Simple-Backtracking

package leetcode.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    private int counter = 0;
    private String ans = "";

    public String getHappyString(int n, int k) {
        LinkedList<String> seq = new LinkedList<>();
        seq.add("");
        Map<String, String[]> map = new HashMap<>();
        map.put("", new String[] { "a", "b", "c" });
        map.put("a", new String[] { "b", "c" });
        map.put("b", new String[] { "a", "c" });
        map.put("c", new String[] { "a", "b" });
        backtrack(n, k, seq, map);
        return ans;
    }

    private void backtrack(int n, int k, LinkedList<String> seq, Map<String, String[]> map) {
        if (counter > k) return;
        
        if (seq.size() == n + 1) {
            if (++counter == k) ans = String.join("", seq);
            return;
        }
        
        for (String ch : map.get(seq.getLast())) {
            seq.add(ch);
            backtrack(n, k, seq, map);
            seq.removeLast();
        }
    }

    public static void main(String[] args) {
        TheKthLexicographicalStringOfAllHappyStringsOfLengthN sln = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN();
        System.out.println(sln.getHappyString(3, 9));
    }

}
