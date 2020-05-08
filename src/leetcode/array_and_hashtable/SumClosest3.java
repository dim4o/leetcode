// Given an array nums of n integers and an integer target, 
// find three integers in nums such that the sum is closest to target. 
// Return the sum of the three integers. You may assume that 
// each input would have exactly one solution.
// See: https://leetcode.com/problems/3sum-closest/

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class SumClosest3 {

    // Optimized O(n.log(n) + n^2) version
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
                
                if (sum == target) 
                    return target;
                else if (sum < target)
                    left++;
                else 
                    right--;
            }
        }

        return closest;
    }

    // Brute force O(n^3) solution (accepted)
    public int threeSumClosest1(int[] nums, int target) {
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < minDiff) {
                        closestSum = sum;
                        minDiff = Math.abs(target - sum);
                    }
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        SumClosest3 sln = new SumClosest3();

        System.out.println(sln.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));

    }

}
