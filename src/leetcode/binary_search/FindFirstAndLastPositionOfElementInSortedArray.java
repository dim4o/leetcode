// Given an array of integers nums sorted in ascending order, find the starting and ending position 
// of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].
// See: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

package leetcode.binary_search;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[] { -1, -1 };
        int left = search(nums, 0, nums.length - 1, target, true);
        int right = search(nums, 0, nums.length - 1, target, false);
        return new int[] { left, right };
    }
    
    private int search(int arr[], int l, int r, int target, boolean left) {
        if (l > r)
            if (left) 
                return arr[l] == target ? l : -1;
            else 
                return arr[r] == target ? r : -1;
            
        int mid = l + (r - l) / 2;
        if (left && arr[mid] >= target || arr[mid] > target)
            return search(arr, l, mid - 1, target, left);
        else 
            return search(arr, mid + 1, r, target, left);
    }

//    private int findLeft(int[] arr, int l, int r, int target) {
//        if (l > r) 
//            return arr[l] == target ? l : -1;
//        int mid = l + (r - l) / 2;
//        if (arr[mid] >= target) 
//            return findLeft(arr, l, mid - 1, target);
//        else
//            return findLeft(arr, mid + 1, r, target);
//    }
//
//    private int findRight(int[] arr, int l, int r, int target) {
//        if (l > r)
//            return arr[r] == target ? r : -1;
//        int mid = l + (r - l) / 2;
//        if (arr[mid] <= target) 
//            return findRight(arr, mid + 1, r, target);
//        else 
//            return findRight(arr, l, mid - 1, target);
//    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray sln = new FindFirstAndLastPositionOfElementInSortedArray();

        int[] nums1 = new int[] { 5, 7, 7, 8, 8, 10 };
        int[] res1 = sln.searchRange(nums1, 8);
        System.out.println(Arrays.toString(res1));

        int[] nums2 = new int[] { 5, 7, 7, 8, 8, 10 };
        int[] res2 = sln.searchRange(nums2, 6);
        System.out.println(Arrays.toString(res2));

        int[] nums3 = new int[] { 1, 2, 3, 4, 5, 7 };
        int[] res3 = sln.searchRange(nums3, 8);
        System.out.println(Arrays.toString(res3));

    }

}
