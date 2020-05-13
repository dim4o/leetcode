// Given an array of integers, find if the array contains any duplicates.
// Your function should return true if any value appears at least twice in the array, 
// and it should return false if every element is distinct.
// See: https://leetcode.com/problems/contains-duplicate/
// Note: This is a very easy problem but it is a good example for time/space tradeoff.

package leetcode.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Solution 2 - Set, O(n) time, O(n) space solution - accepted. 
     * Actually in practice this solution is not faster than Solution 2(sorting) for leetcode test cases
     * because of the high coast of set(add, contains) operations - although the constant time.
     * Actually this "constant time" is higher compared to array operations.
     */
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else return true;
        }
        return false;
    }
    
    /**
     * Solution 2 - Sorting, O(n.log(n)) time solution - accepted. 
     */
    public boolean containsDuplicate_var2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Solution 1 - Naive bruteforce, O(n^2) time solution - not accepted(TLE).
     */
    public boolean containsDuplicate_var1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
