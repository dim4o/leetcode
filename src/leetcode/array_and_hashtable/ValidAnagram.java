// Given two strings s and t , write a function to determine if t is an anagram of s.
// See: https://leetcode.com/problems/valid-anagram/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    /**
     * Solution 4 - Array solution: O(n) time, O(1) space (Fast solution).
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            alphabet[ch1[i] - 'a']++;
            alphabet[ch2[i] - 'a']--;
        }
        
        for (int i : alphabet)
            if (i != 0) 
                return false;

        return true;
    }
    /**
     * Solution 3 - Sort solution. O(n.log(n)) time, O(1) space.
     */
    public boolean isAnagram_var3(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        
        return Arrays.equals(s1, s2);
    }
    
    /**
     * Solution 2 - HashMap solution.
     */
    public boolean isAnagram_var2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                int count = map.get(ch) - 1;
                if (count == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, count);
                }
            }
        }
        
        return true;
    }
    /**
     * Solution 1 - Array solution.
     */
    public boolean isAnagram_var1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet1 = new int[26];
        int[] alphabet2 = new int[26];
        for (int ch : s.toCharArray())
            alphabet1[ch - 'a']++;
        
        for (int ch : t.toCharArray())
            alphabet2[ch - 'a']++;

        return Arrays.equals(alphabet1, alphabet2);
    }

}
