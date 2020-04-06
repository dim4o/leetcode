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
     * Initial solution.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
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
