// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
// Note: Your algorithm should have a linear runtime complexity. 
// Could you implement it without using extra memory?
// See: https://leetcode.com/problems/single-number/
// See: https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3283/

package leetcode.leetcode_challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    /**
     * Solution 3 - Simple Bit manipulations.
     * May be the best solution: O(n) time, O(1) space.
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }

    /**
     * Solution 2 - Simple Math solution.
     */
    public int singleNumber_var2(int[] nums) {
        int sum = 0;
        int uniqueSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum += num;
            if (!set.contains(num)) {
                set.add(num);
                uniqueSum += num;
            }
        }

        return uniqueSum * 2 - sum;
    }

    /**
     * Solution 1 - Hash Table solution.
     */
    public int singleNumber_var1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber sln = new SingleNumber();

        System.out.println(sln.singleNumber(new int[] { 2, 2, 1 }));
        System.out.println(sln.singleNumber(new int[] { 4, 1, 2, 1, 2 }));

    }

}
