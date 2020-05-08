// Given an array of integers that is already sorted in ascending order, 
// find two numbers such that they add up to a specific target number.
// The function twoSum should return indices of the two numbers such that they add up to the target, 
// where index1 must be less than index2.
// Note:
//   Your returned answers (both index1 and index2) are not zero-based.
//   You may assume that each input would have exactly one solution and you may not use the same element twice.
// See: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class Sum2InputArrayIsSorted {
    /**
     * Two pointers solution.
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) r--;
            else if (numbers[l] + numbers[r] < target) l++;
            else break;
        }
        return new int[] { l + 1, r + 1 };
    }

    public static void main(String[] args) {
        Sum2InputArrayIsSorted sln = new Sum2InputArrayIsSorted();
        System.out.println(Arrays.toString(sln.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }

}
