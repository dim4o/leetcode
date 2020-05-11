// Given a pattern and a string str, find if str follows the same pattern.
// Here follow means a full match, such that there is a bijection between a letter in pattern 
// and a non-empty word in str.
// See: https://leetcode.com/problems/word-pattern/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        char[] chars = pattern.toCharArray();
        Map<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i]) && !map.get(chars[i]).equals(words[i]))
                return false;
            else map.put(chars[i], words[i]);
        }
        
        return map.size() == new HashSet<>(Arrays.asList(words)).size();
    }

    public static void main(String[] args) {
        WordPattern sln = new WordPattern();
        System.out.println(sln.wordPattern("abba", "dog cat cat dog"));
        System.out.println(sln.wordPattern("abba", "dog cat cat fish"));
        System.out.println(sln.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(sln.wordPattern("abba", "dog dog dog dog"));
    }

}
