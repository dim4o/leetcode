// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
// find the one that is missing from the array.
// See: https://leetcode.com/problems/missing-number/

package leetcode.math;

import java.util.Arrays;

public class MissingNumber {
    // Concise solution but for better performance use for loop instead stream
    public int missingNumber(int[] nums) {
        return (nums.length * (nums.length + 1)) / 2 - Arrays.stream(nums).sum();
    }
}
