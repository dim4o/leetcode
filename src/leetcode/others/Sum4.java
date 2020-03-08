// Given an array nums of n integers and an integer target, 
// are there elements a, b, c, and d in nums such that a + b + c + d = target? 
// Find all unique quadruplets in the array which gives the sum of target.
// The solution set must not contain duplicate quadruplets.

package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    // O(n.log(n) + n^3) time complexity, O(1) space (without the output list)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        quadruplets.add(Arrays.asList(
                                new Integer[] { nums[i], nums[j], nums[left], nums[right] }));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) 
                        left++;
                    else 
                        right--;
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        Sum4 sln = new Sum4();

        System.out.println(sln.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
        System.out.println(sln.fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0));
        System.out.println(sln.fourSum(new int[] { 5, 5, 3, 5, 1, -5, 1, -2 }, 4));
    }

}
