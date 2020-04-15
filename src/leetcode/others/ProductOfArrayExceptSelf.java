// Given an array nums of n integers where n > 1,  return an array output such that 
// output[i] is equal to the product of all the elements of nums except nums[i].
// Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array 
// (including the whole array) fits in a 32 bit integer.
// Note: Please solve it without division and in O(n).
// Follow up:
// Could you solve it with constant space complexity? 
// (The output array does not count as extra space for the purpose of space complexity analysis.)

package leetcode.others;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * O(n) time, O(2n) space solution without division.
     * TODO: constant space solution.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] p1= new int[nums.length + 1];
        int[] p2 = new int[nums.length + 1];
        p1[0] = 1;
        p2[p2.length - 1] = 1;
        
        for (int i = 1; i < p1.length; i++) 
            p1[i] = nums[i - 1] * p1[i - 1];
        
        for (int i = p2.length - 2; i >= 0; i--) 
            p2[i] = nums[i] * p2[i + 1];
       
        for (int i = 0; i < res.length; i++)
            res[i] = p1[i] * p2[i + 1];

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf sln = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(sln.productExceptSelf(new int[] {1, 2, 3, 4})));
    }

}
