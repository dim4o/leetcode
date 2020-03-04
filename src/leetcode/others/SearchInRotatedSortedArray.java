// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
// You are given a target value to search. If found in the array return its index, otherwise -1.
// You may assume no duplicate exists in the array.
// Your algorithm's runtime complexity must be in the order of O(log n).
// See: https://leetcode.com/problems/search-in-rotated-sorted-array/

package leetcode.others;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    /**
     * The idea is to find the pivot where nums[pivot] < mums[pivot-1].
     * Then the numbers that are on the left side of the pivot and those on the right side are sorted
     * and we can use a plain Binary Search. So we have 3 steps with log(N) time:
     *     1. Find the pivot where nums[pivot] < mums[pivot-1] with log(N) time.
     *     2. Search on the left side of the pivot: binarySearch(nums, 0, pivot, target) 
     *        with log(N) time.
     *     3. Search on the right side of the pivot(inclusive): 
     *        binarySearch(nums, pivot, nums.length, target) with log(N) time.
     */
    public int search(int[] nums, int target) {
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

        if (pivot < 0) {
            int res = Arrays.binarySearch(nums, target);
            return res < 0 ? -1 : res;
        }

        int left = Arrays.binarySearch(nums, 0, pivot, target);
        int right = Arrays.binarySearch(nums, pivot, nums.length, target);

        if (left < 0 && right < 0) return -1;
        return left < 0 ? right : left;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sln = new SearchInRotatedSortedArray();

        System.out.println(sln.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(sln.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));

        System.out.println(sln.search(new int[] { 1 }, 0));
        System.out.println(sln.search(new int[] { 1 }, 2));
    }

}
