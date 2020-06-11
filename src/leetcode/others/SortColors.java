// Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
// Note: You are not suppose to use the library's sort function for this problem.
// Follow up: Could you come up with a one-pass algorithm using only constant space?
// See: https://leetcode.com/problems/sort-colors/
// See: https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/

package leetcode.others;

public class SortColors {

    // TODO: One pass solution with O(1) space

    /**
     * Counting sort solution, two passes solution O(N) time, O(1) space
     */
    public void sortColors(int[] nums) {
        int[] countArr = new int[3];
        for (int num : nums)
            countArr[num]++;

        int i = 0;
        for (int j = 0; j < countArr.length; j++)
            while (countArr[j]-- > 0)
                nums[i++] = j;
    }

    public static void main(String[] args) {
        SortColors sln = new SortColors();
        sln.sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
    }

}
