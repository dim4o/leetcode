// Given an array of integers and an integer k, find out whether there are 
// two distinct indices i and j in the array such that nums[i] = nums[j] and 
// the absolute difference between i and j is at most k.
// See: https://leetcode.com/problems/contains-duplicate-ii/

package leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicate2 {
    /**
     * Optimal solution.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k)
                    return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    /**
     * Initial solution(not optimal).
     */
    public boolean containsNearbyDuplicate_var1(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> idx = map.get(nums[i]);
                for (Integer id : idx) {
                    if (Math.abs(id - i) <= k) {
                        return true;
                    }
                }
                idx.add(i);
                map.put(nums[i], idx);
            } else {
                map.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
            }
        }

//        System.out.println(map);

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 sln = new ContainsDuplicate2();
        System.out.println(sln.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        System.out.println(sln.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        System.out.println(sln.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));

    }
}
