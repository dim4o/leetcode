// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
// Find the minimum element.
// The array may contain duplicates.
// See: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// See: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/

package leetcode.binary_search;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray2 {

    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1] || nums.length == 1)
            return nums[0];

        return nums[binHelper(nums, 0, nums.length - 1)];
    }

    private int binHelper(int[] nums, int left, int right) {
        if (nums[left] == nums[right]) {
            // do a linear search
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[i + 1])
                    return i + 1;
            }
        }

        if (left == right - 1)
            return right;

        int mid = (left + right) / 2;
        if (nums[mid] > nums[right])
            return binHelper(nums, mid, right);

        return binHelper(nums, left, mid);
    }

    /**
     * Better than brute force solution but still not optimal (Accepted). O(N) time,
     * O(1) space
     */
    public int findMin2(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return nums[i];
            }
        }

        return nums[0];
    }

    /**
     * An attempt to find naive/brute force solution(Accepted) O(N.log(N)) time,
     * O(1) space
     */
    public int findMin1(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray2 sln = new FindMinimumInRotatedSortedArray2();

//        System.out.println(sln.findMin(new int[] { 4,5,6,7,0,1,2 }));
//        
//        System.out.println(sln.findMin(new int[] { 4,5,6,7,7,0, 0,1,2 }));
//        
//        System.out.println(sln.findMin(new int[] { 1, 3, 5 }));
//        
//        System.out.println(sln.findMin(new int[] { 2,2,2,0,1 }));

//        System.out.println(sln.findMin(new int[] { 3, 1, 3, 3, 3}));
        System.out.println(sln.findMin(new int[] { 1, 2, 1, 1 }));
        System.out.println(sln.findMin(new int[] { 1, 1 }));

    }

}
