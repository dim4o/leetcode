// You are given two arrays (without duplicates) nums1 and nums2 where nums1’s 
// elements are subset of nums2. Find all the next greater numbers for nums1's 
// elements in the corresponding places of nums2.
// The Next Greater Number of a number x in nums1 is the first greater number 
// to its right in nums2. If it does not exist, output -1 for this number.
// See: https://leetcode.com/problems/next-greater-element-i/
// Related: https://leetcode.com/problems/next-greater-node-in-linked-list/

package leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    /**
     * Solution with stack.
     * O(n) time, O(n) space.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < nums1.length; i++)
            map.put(nums1[i], i);
        
        for (int num : nums2) {
            while (!stack.empty() && num > stack.peek()[0]) 
                nums1[stack.pop()[1]] = num;
            if (map.containsKey(num)) 
                stack.add(new int[] {num,  map.get(num)});
        }
        while (!stack.empty()) 
            nums1[stack.pop()[1]] = -1;

        return nums1;
    }
    
    /**
     * Naive solution. O(n^2) time, O(1) space(without the output).
     */
    public int[] nextGreaterElement_var1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean searchForNext = false;
            boolean found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    searchForNext = true;
                    continue;
                }
                if (searchForNext && nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    found = true;
                    break;
                }
            }
            if (!found)
                result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement1 sln = new NextGreaterElement1();
        int[] nums1 = new int[] {4, 1, 2};
        int[] nums2 = new int[] {1, 3, 4, 2};
        int[] result1 = sln.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result1));
        
        int[] nums11 = new int[] {2, 4};
        int[] nums22 = new int[] {1, 2, 3, 4};
        int[] result11 = sln.nextGreaterElement(nums11, nums22);
        System.out.println(Arrays.toString(result11));
    }
}
