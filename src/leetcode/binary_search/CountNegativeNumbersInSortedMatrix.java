// Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 
// Return the number of negative numbers in grid.
// See: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

package leetcode.binary_search;

public class CountNegativeNumbersInSortedMatrix {

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) 
            count += search(grid[i], 0, grid[0].length - 1);
        return count;
    }

    private int search(int[] nums, int lo, int hi) {
        if (lo > hi)
            return nums.length - lo;

        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < 0)
            return search(nums, lo, mid - 1);

        return search(nums, mid + 1, hi);
    }

    public static void main(String[] args) {
        CountNegativeNumbersInSortedMatrix sln = new CountNegativeNumbersInSortedMatrix();

        int[] arr = new int[] { 1, -1 };
        System.out.println(sln.search(arr, 0, arr.length - 1));

        int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
        System.out.println(sln.countNegatives(grid));
    }

}
