// Given an integer array nums, design an algorithm to randomly shuffle the array. 
// All permutations of the array should be equally likely as a result of the shuffling.
//
// Implement the Solution class:
//
// Solution(int[] nums) Initializes the object with the integer array nums.
// - int[] reset() Resets the array to its original configuration and returns it.
// - int[] shuffle() Returns a random shuffling of the array.
// See: https://leetcode.com/problems/shuffle-an-array/

package leetcode.design;

import java.util.Arrays;
import java.util.Random;

/**
 * Actually this is an implementation of Fisher-Yates algorithm
 */
public class ShuffleAnArray {

    class Solution {
        private int[] origin;
        private int[] nums;
        private Random rnd = new Random();

        public Solution(int[] nums) {
            origin = nums.clone();
            this.nums = nums;
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            // the initial solution was from start to end
            // but in this case is easier to iterate backwards
            for (int i = nums.length - 1; i >= 0; i--) {
                swap(i, rnd.nextInt(i + 1));
            }
            
            return nums;
        }
        
        private void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution sln = new ShuffleAnArray().new Solution(new int[] {1, 2, 3, 4});
        
        System.out.println(Arrays.toString(sln.shuffle()));
    }
}
