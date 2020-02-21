// Given a string s, partition s such that every 
// substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
// See: https://leetcode.com/problems/palindrome-partitioning/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(s, 0, result, new Stack<>());
        
        return result;
    }
    
    private void helper(String s, int start, List<List<String>> result, Stack<String> curr) {
        if (start == s.length()) {
            result.add(new ArrayList<>(curr));
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                
                helper(s, i + 1, result, curr);
                
                curr.pop();
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        int len = (start + end + 1) / 2;
        for (int k = start; k < len; k++)
            if (s.charAt(k) != s.charAt(end + start - k))
                return false;
            
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning sln = new PalindromePartitioning();
        System.out.println(sln.partition("aab"));
        
        // System.out.println(sln.isPalindrome("babba", 1, 4));
    }

}
