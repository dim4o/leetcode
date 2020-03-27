// Given an array of integers arr, write a function that returns true if and only if 
// the number of occurrences of each value in the array is unique.
// See: https://leetcode.com/problems/unique-number-of-occurrences/

package leetcode.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    // HashMap solution.
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        return new HashSet<>(map.values()).size() == map.values().size() ? true : false;
    }

}
