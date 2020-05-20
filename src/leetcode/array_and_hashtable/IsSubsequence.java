// Given a string s and a string t, check if s is subsequence of t.
// A subsequence of a string is a new string which is formed from the original string 
// by deleting some (can be none) of the characters without disturbing the relative positions 
// of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
// See: https://leetcode.com/problems/is-subsequence/

package leetcode.array_and_hashtable;

public class IsSubsequence {
    
    // O(n + m) time
    // Think about the edge cases! For example what if the first string is empty? Or the second string is empty?
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        
        int j = 0;
        char[] second = t.toCharArray();
        char[] first = s.toCharArray();
        
        for (int i = 0; i < first.length; i++) {
            while (j < second.length) {
                if (second[j++] == first[i]) {
                    if (i == first.length - 1) return true;
                    break;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        IsSubsequence sln = new IsSubsequence();
        System.out.println(sln.isSubsequence("", "ahbgdc"));
        System.out.println(sln.isSubsequence("abc", "ahbgdc"));
        System.out.println(sln.isSubsequence("axc", "ahbgdc"));
        
        System.out.println(sln.isSubsequence("abc", "aaabbbddd"));
        System.out.println(sln.isSubsequence("a", "ba"));

    }

}
