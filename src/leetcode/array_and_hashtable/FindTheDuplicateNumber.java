// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
// prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
// find the duplicate one.
// See: https://leetcode.com/problems/find-the-duplicate-number/

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (nums[j] != j + 1) {
                if (nums[nums[j] - 1] == nums[j])
                    return nums[j];
                int tmp = nums[nums[j] - 1];
                nums[nums[j] - 1] = nums[j];
                nums[j] = tmp;
                j = nums[j] - 1;
            }
        }

        return -1;
    }

    public int findDuplicate_var1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                return nums[i];

        // return a dummy value
        return -1;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber sln = new FindTheDuplicateNumber();
        System.out.println(sln.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
        System.out.println(sln.findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
    }

}
