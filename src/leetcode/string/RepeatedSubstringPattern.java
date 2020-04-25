// Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple 
// copies of the substring together. You may assume the given string consists of lowercase English letters only 
// and its length will not exceed 10000.
// See: https://leetcode.com/problems/repeated-substring-pattern/

package leetcode.string;

public class RepeatedSubstringPattern {
    
    public boolean repeatedSubstringPattern(String s) {
        for (int len = 1; len <= s.length()/2; len++)
            if (s.length() % len == 0) {
                for (int i = 0; i < s.length() - len; i++) {
                    if (s.charAt(i) != s.charAt(i + len)) break;
                    if (i == s.length() - len - 1) 
                        return true;
                }
            }
        return false;
    }
    
    /**
     * Elementary solution.
     */
    public boolean repeatedSubstringPattern_var1(String s) {
        for (int len = 1; len <= s.length()/2; len++)
            if (s.length() % len == 0) 
                if (s.replace(s.substring(0, len), "").isEmpty()) 
                    return true;
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern sln = new RepeatedSubstringPattern();
        System.out.println(sln.repeatedSubstringPattern("abab"));
        System.out.println(sln.repeatedSubstringPattern("aba"));
        System.out.println(sln.repeatedSubstringPattern("abcabcabcabc"));
        

    }

}
