// Given an array of strings, group anagrams together.
// See: https://leetcode.com/problems/group-anagrams/

package leetcode.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /**
     * Efficient solution with counting sort instead Arrays.sort(something).
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String currStr : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < currStr.length(); i++)
                counts[currStr.charAt(i) - 97]++;
            sb.setLength(0);
            for (int i = 0; i < counts.length; i++)
                for (int j = 0; j < counts[i]; j++)
                    sb.append('a' + i);

            map.computeIfAbsent(sb.toString(), k -> new LinkedList<>()).add(currStr);
        }

        return new LinkedList<>(map.values());
    }

    /**
     * This solution is actually slower than the initial solution.
     */
    public List<List<String>> groupAnagrams_var2(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String currStr : strs) {
            Map<Character, Integer> currMap = new HashMap<>();
            for (int i = 0; i < currStr.length(); i++)
                currMap.put(currStr.charAt(i), currMap.getOrDefault(currStr.charAt(i), 0) + 1);
            map.computeIfAbsent(currMap, k -> new LinkedList<>()).add(currStr);
        }

        return new LinkedList<>(map.values());
    }

    /**
     * Initial solution.
     */
    public List<List<String>> groupAnagrams_var1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String currStr : strs) {
            char[] curr = currStr.toCharArray();
            Arrays.sort(curr);
            map.computeIfAbsent(new String(curr), k -> new LinkedList<>()).add(currStr);
        }

        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sln = new GroupAnagrams();
        System.out.println(
                sln.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

        System.out.println(sln.groupAnagrams(new String[] { "", "" }));

    }

}
