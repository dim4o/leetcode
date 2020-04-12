// Suppose an array sorted in ascending order is rotated 
// at some pivot unknown to you beforehand.
// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
// You are given a target value to search. If found in the array return true, 
// otherwise return false.
// See: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

package leetcode.binary_search;

import java.util.Arrays;

public class SearchInRotatedSortedArray2 {

    /**
     * O(log(N)) time for the average case. 
     * In the worst case scenario O(N)
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        // The worst scenario when most of the numbers or all are equal
        if (nums[0] == nums[nums.length - 1]) {
            for (int i : nums)
                if (i == target)
                    return true;
            return false;
        }
        int lo = 0, hi = nums.length - 1, pivot = -1;
        while (lo <= hi) {
            pivot = (lo + hi) / 2;
            if (pivot > 0 && nums[pivot] < nums[pivot - 1])
                break;
            else if (nums[0] > nums[pivot])
                hi = pivot - 1;
            else
                lo = pivot + 1;
        }

        if (pivot < 0)
            return Arrays.binarySearch(nums, target) > -1;

        return Arrays.binarySearch(nums, 0, pivot, target) > -1
                || Arrays.binarySearch(nums, pivot, nums.length, target) > -1;
    }

    /**
     * Simple but not optimal solution. Time complexity N + log(N).
     */
    public boolean search1(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int piv = 0;
        for (int i = 1; i < nums.length; i++)
            if (min > nums[i] && nums[i] < nums[i - 1]) {
                min = nums[i];
                piv = i;
                break;
            }

        return Arrays.binarySearch(nums, 0, piv, target) > -1
                || Arrays.binarySearch(nums, piv, nums.length, target) > -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray2 sln = new SearchInRotatedSortedArray2();

        System.out.println(sln.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0)); // true
        System.out.println(sln.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3)); // false
        System.out.println(sln.search(new int[] { 2, 2, 2, 2, 0, 2, 2 }, 0)); // true
        System.out.println(sln.search(new int[] { 3, 1, 1, 1, 1 }, 3)); // true
        System.out.println(sln.search(new int[] { 1, 3, 1, 1, 1, 1 }, 3)); // true
        System.out.println(sln.search(new int[] { 1, 3, 1, 1, 1, 1 }, 4)); // false

    }

}
