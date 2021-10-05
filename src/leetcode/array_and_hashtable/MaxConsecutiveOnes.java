// Given an array nums of integers, return how many of them contain an even number of digits.
// See: https://leetcode.com/problems/max-consecutive-ones/

package leetcode.array_and_hashtable;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) 
                max = Math.max(++currMax, max);
            else
               currMax = 0; 
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes sln = new MaxConsecutiveOnes();
        System.out.println(sln.findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
        System.out.println(sln.findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }

}
