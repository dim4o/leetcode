// Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
// In other words, one of the first string's permutations is the substring of the second string.
// See: https://leetcode.com/problems/permutation-in-string/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
// Note: this problem is related to:
//   - See: https://leetcode.com/problems/find-all-anagrams-in-a-string/
//   - See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/

package leetcode.leetcode_challenge;

public class PermutationInString {
    
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        
        int[] countArr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            countArr[s2.charAt(i) - 'a']++;
            countArr[s1.charAt(i) - 'a']--;
        }
        
        if (isZero(countArr))
            return true;
        
        for (int i = s1.length(); i < s2.length(); i++) {
            countArr[s2.charAt(i) - 'a']++;
            countArr[s2.charAt(i - s1.length()) - 'a']--;
            if (isZero(countArr))
                return true;
        }
       
        return false;
    }
    
    private boolean isZero(int[] countArr) {
        for (int count : countArr)
            if (count != 0) return false;
        return true;
    }
    
    public static void main(String[] args) {
        PermutationInString sln = new PermutationInString();
        System.out.println(sln.checkInclusion("ab", "eidbaooo"));
    }

}
