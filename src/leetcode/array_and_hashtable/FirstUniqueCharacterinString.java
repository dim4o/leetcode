// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
// See: https://leetcode.com/problems/first-unique-character-in-a-string/solution/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/

package leetcode.array_and_hashtable;

public class FirstUniqueCharacterinString {
    
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        for (int character : s.toCharArray())
            alphabet[character - 'a']++;
        
        for (int i = 0; i < s.length(); i++)
            if (alphabet[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

}
