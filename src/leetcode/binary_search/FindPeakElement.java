// A peak element is an element that is greater than its neighbors.
// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
// You may imagine that nums[-1] = nums[n] = -∞.
// See: https://leetcode.com/problems/find-peak-element/
// See also: https://leetcode.com/problems/peak-index-in-a-mountain-array/

package leetcode.binary_search;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int nums[], int l, int r) {
        if (l == r)
            return r;

        int mid = (l + r) / 2;

        if (nums[mid] > nums[mid + 1])
            return findPeak(nums, l, mid); // search left

        return findPeak(nums, mid + 1, r); // search right

    }

    public static void main(String[] args) {
        FindPeakElement sln = new FindPeakElement();
        System.out.println(sln.findPeakElement(new int[] { 1, 2, 3, 1 }));
        System.out.println(sln.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));

        System.out.println(sln.findPeakElement(new int[] { 1, 2, 3, 4 }));

        System.out.println(sln.findPeakElement(new int[] { 5, 4, 3, 2, 1 }));

        System.out.println(sln.findPeakElement(new int[] { 1, 2 }));
        System.out.println(sln.findPeakElement(new int[] { 2, 1 }));

        System.out.println(sln.findPeakElement(new int[] { 3, 4, 3, 2, 1 }));
    }

}
