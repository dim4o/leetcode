// Given a string, sort it in decreasing order based on the frequency of characters.
// See: https://leetcode.com/problems/sort-characters-by-frequency/

package leetcode.array_and_hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        // Add the characters to a HashMap and keep the frequency as a value
        Map<Character, Integer> map = new HashMap<>();
        for (char character : s.toCharArray())
            map.put(character, map.getOrDefault(character, 0) + 1);
        // Add the (key, value) pairs to a list
        List<int[]> list = new ArrayList<>();
        for (char character : map.keySet())
            list.add(new int[] { (int) character, map.get(character) });
        // Sort the list by the value
        Collections.sort(list, (a, b) -> b[1] - a[1]);

        StringBuilder res = new StringBuilder();
        for (int[] pair : list)
            for (int i = 0; i < pair[1]; i++)
                res.append((char) pair[0]);

        return res.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sln = new SortCharactersByFrequency();
        System.out.println(sln.frequencySort("tree"));
    }

}
