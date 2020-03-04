// Suppose an array sorted in ascending order is rotated at some pivot 
// unknown to you beforehand.
// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
// Find the minimum element.
// You may assume no duplicate exists in the array.
// See: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

package leetcode.others;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, pivot = -1;
        while (lo <= hi) {
            pivot = (lo + hi) / 2;
            if (pivot > 0 && nums[pivot] < nums[pivot - 1])
                return nums[pivot];
            else if (nums[0] > nums[pivot])
                hi = pivot - 1;
            else
                lo = pivot + 1;
        }
        
        return nums[0];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sln = new FindMinimumInRotatedSortedArray();
        System.out.println(sln.findMin(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println(sln.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        System.out.println(sln.findMin(new int[] { 1 }));
        System.out.println(sln.findMin(new int[] { 1, 2 }));
    }

}
