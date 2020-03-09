// Given an array nums, write a function to move all 0's to the end of it 
// while maintaining the relative order of the non-zero elements.
// See: https://leetcode.com/problems/move-zeroes/

package leetcode.others;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                nums[lastNonZero] = nums[i];
                lastNonZero++;
            }

        for (int i = lastNonZero; i < nums.length; i++)
            nums[i] = 0;
        // System.out.println(Arrays.toString(nums));
    }
    
    // Accepted but sub-optimal
    public void moveZeroes1(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length && l < nums.length) {
            while (l < nums.length && nums[l] != 0) l++;
            r = l + 1;
            while (r < nums.length && nums[r] == 0) r++;

            if (l < nums.length && r < nums.length) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes sln = new MoveZeroes();

        sln.moveZeroes(new int[] { 0, 1, 0, 3, 12 });
        sln.moveZeroes(new int[] { 1, 0, 0, 3, 12 });
        sln.moveZeroes(new int[] { 1, 2, 0, 3 });
    }

}
