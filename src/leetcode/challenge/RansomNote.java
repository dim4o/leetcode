// Given an arbitrary ransom note string and another string containing letters from all the magazines, 
// write a function that will return true if the ransom note can be constructed from the magazines ; 
// otherwise, it will return false.
// Each letter in the magazine string can only be used once in your ransom note.
// Note:
// You may assume that both strings contain only lowercase letters.
// See: https://leetcode.com/problems/ransom-note/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    /**
     * Array solution.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (int i = 0; i < mag.length; i++)
            arr[mag[i] - 'a']++;
            
        for (int i = 0; i < note.length; i++) {
            if (arr[note[i] - 'a'] == 0)
                return false;
            arr[note[i] - 'a']--;
        }
        return true;
    }
    
    /**
     * HashMap solution.
     */
    public boolean canConstruct_hashmap(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++)
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0) + 1);
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0)
                return false;
            map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
        }
        return true;
    }

}
