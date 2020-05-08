// Given an array of integers, return indices of the two numbers such that 
// they add up to a specific target.
// You may assume that each input would have exactly one solution, 
// and you may not use the same element twice.
// See: https://leetcode.com/problems/two-sum/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Optimal solution with linear time complexity O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        
        return null;
    }
    
    public int[] twoSum_bruteforce(int[] nums, int target) {
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum sln = new TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        
        System.out.println(Arrays.toString(sln.twoSum(nums, target)));
    }
}
