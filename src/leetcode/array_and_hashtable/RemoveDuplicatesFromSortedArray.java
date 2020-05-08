// Given a sorted array nums, remove the duplicates in-place 
// such that each element appear only once and return the new length.
// Do not allocate extra space for another array, 
// you must do this by modifying the input array in-place with O(1) extra memory.
// See: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package leetcode.array_and_hashtable;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int pos = 1;
        int i = 1;
        while (i < nums.length && pos < nums.length) {
            while (i < nums.length && nums[i] == nums[i - 1]) i++;

            if (i < nums.length)
                nums[pos++] = nums[i++];
        }
        
        // System.out.println(Arrays.toString(nums));

        return pos;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray sln = new RemoveDuplicatesFromSortedArray();
        sln.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
        
        sln.removeDuplicates(new int[] { 0, 0, 1});

    }

}
