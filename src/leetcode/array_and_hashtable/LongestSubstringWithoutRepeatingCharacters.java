// Given a string, find the length of the longest substring without repeating characters.
// See: https://leetcode.com/problems/longest-substring-without-repeating-characters/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Solution 3 - Optimized version of Solution 2
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int left = 0, max = 0;
        char[] arr = s.toCharArray();
        for (int right = 0; right < arr.length; right++) {
            if (map[arr[right]] >= left)
                left = map[arr[right]] + 1;
            max = Math.max(right - left + 1, max);
            map[arr[right]] = right;
        }
        
        return max;
    }
    
    /**
     * Solution 2 - Optimized version of Solution 1
     */
    public int lengthOfLongestSubstring_var2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        for (int right = 0; right < arr.length; right++) {
            if (map.containsKey(arr[right]) && map.get(arr[right]) >= left)
                left = map.get(arr[right]) + 1;
            max = Math.max(right - left + 1, max);
            map.put(arr[right], right);
        }
        
        return max;
    }
    
    /**
     * Solution 1
     */
    public int lengthOfLongestSubstring_var1(String s) {
        if (s.length() < 2)
            return s.length();
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 1;
        char[] arr = s.toCharArray();
        for (int right = 0; right < arr.length; right++) {
            if (map.containsKey(arr[right])){
                int newLeftPosition = map.get(arr[right]) + 1;
                for (int i = left; i < newLeftPosition; i++)
                    map.remove(arr[i]);
                left = newLeftPosition;
            }
            max = Math.max(right - left + 1, max);
            map.put(arr[right], right);
        }
        
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sln = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sln.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sln.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sln.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sln.lengthOfLongestSubstring(""));
        System.out.println(sln.lengthOfLongestSubstring("a"));
        System.out.println(sln.lengthOfLongestSubstring("au"));
        System.out.println(sln.lengthOfLongestSubstring("abba"));
        System.out.println(sln.lengthOfLongestSubstring("aab"));
        System.out.println(sln.lengthOfLongestSubstring("tmmzuxt")); // 5

    }

}
