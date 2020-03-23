// Given a circular array (the next element of the last element is the first 
// element of the array), print the Next Greater Number for every element. 
// The Next Greater Number of a number x is the first greater number to its 
// traversing-order next in the array, which means you could search circularly 
// to find its next greater number. If it doesn't exist, output -1 for this number.
// See: https://leetcode.com/problems/next-greater-element-ii/

package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++)
            ans[i] = -1;
        
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < 2*n; i++) {
            while (!stack.empty() && nums[i % n] > stack.peek()[0])
                ans[stack.pop()[1]] = nums[i % n];
            stack.add(new int[] { nums[i % n], i % n });
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElement2 sln = new NextGreaterElement2();
        
        System.out.println(Arrays.toString(sln.nextGreaterElements(new int[] { 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(sln.nextGreaterElements(new int[] { 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(sln.nextGreaterElements(new int[] { 1, 2, 3, 2, 1 })));

    }

}
