// Given an array nums and a value val, remove all instances of that value 
// in-place and return the new length.
// Do not allocate extra space for another array, you must do this by 
// modifying the input array in-place with O(1) extra memory.
// The order of elements can be changed. 
// It doesn't matter what you leave beyond the new length.
// See: https://leetcode.com/problems/remove-element/
// Almost the same problem is here: See: https://leetcode.com/problems/move-zeroes/

package leetcode.others;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int pivot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pivot] = nums[i];
                pivot++;
            }
        }
        
        return pivot;
    }

    public static void main(String[] args) {
        RemoveElement sln = new RemoveElement();
        System.out.println(sln.removeElement(new int[] { 3, 2, 2, 3 }, 3));
    }

}
