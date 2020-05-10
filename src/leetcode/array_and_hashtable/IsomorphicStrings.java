// Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving 
// the order of characters. No two characters may map to the same character but a character may map to itself.
// See: https://leetcode.com/problems/isomorphic-strings/

package leetcode.array_and_hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (map.containsKey(si) && ti != map.get(si))
                return false;
            else
                map.put(si, ti);
        }
        Set<Character> set = new HashSet<>();
        for (char character : t.toCharArray())
            set.add(character);
        
        return map.size() == set.size();
    }
    
    public boolean isIsomorphic_var2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> dict = new HashMap<>();
        String test = "";
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (!dict.containsKey(si))
                dict.put(si, ti);
            test += dict.get(si);
        }
        Set<Character> set = new HashSet<>();
        for (char character : t.toCharArray())
            set.add(character);
        
        return t.equals(test) && dict.size() == set.size();
    }
    
    public boolean isIsomorphic_var1(String s, String t) {
        return isIs(s, t) && isIs(t, s);
    }
    
    private boolean isIs(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (map.containsKey(si) && ti != map.get(si))
                return false;
            else
                map.put(si, ti);
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsomorphicStrings sln = new IsomorphicStrings();
        System.out.println(sln.isIsomorphic("ab", "aa"));
        System.out.println(sln.isIsomorphic("ab", "ca"));
        System.out.println(sln.isIsomorphic("foo", "bar"));
        System.out.println(sln.isIsomorphic("egg", "add"));

    }

}
