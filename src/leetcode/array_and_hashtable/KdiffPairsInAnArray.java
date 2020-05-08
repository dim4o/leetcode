// Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
// Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array 
// and their absolute difference is k.
// See: https://leetcode.com/problems/k-diff-pairs-in-an-array/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KdiffPairsInAnArray {
    /**
     * Initial Solution(Accepted).
     * TODO: optimize the solution.
     */
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
        Arrays.sort(nums);
        Set<List<Integer>> resSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num))
                if (map.get(num) <= num)
                    resSet.add(Arrays.asList(new Integer[] { map.get(num), num }));
                else
                    resSet.add(Arrays.asList(new Integer[] { num, map.get(num) }));
            map.put(num + k, num);
            map.put(num - k, num);
        }
        return resSet.size();
    }

    public static void main(String[] args) {
        KdiffPairsInAnArray sln = new KdiffPairsInAnArray();

        System.out.println(sln.findPairs(new int[] { 3, 1, 4, 1, 5 }, 2)); // 2
        System.out.println(sln.findPairs(new int[] { 1, 2, 3, 4, 5 }, 1)); // 4
        System.out.println(sln.findPairs(new int[] { 1, 3, 1, 5, 4 }, 0)); // 1
        System.out.println(sln.findPairs(new int[] { 1, 2, 3, 4, 5 }, -1)); // 0
        System.out.println(sln.findPairs(new int[] { 1, 1, 1, 1, 1 }, 0)); // 1
        System.out.println(sln.findPairs(new int[] { 1, 1, 1, 2, 2 }, 0)); // 2
        System.out.println(sln.findPairs(new int[] { 1, 1, 1, 2, 2 }, 1)); // 1
    }

}
