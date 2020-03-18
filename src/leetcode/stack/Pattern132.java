// Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak 
// such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers 
// as input and checks whether there is a 132 pattern in the list.
// See: https://leetcode.com/problems/132-pattern/
// See: https://leetcode.com/problems/132-pattern/discuss/94089/Java-solutions-from-O(n3)-to-O(n)-for-"132"-pattern-(updated-with-one-pass-slution)

package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pattern132 {
    
    /**
     * Stack solution, not for mere mortals,
     * O(n) time, O(n) space complexity.
     * See: https://leetcode.com/problems/132-pattern/solution/
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] minArr = new int[nums.length];
        minArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) 
            minArr[i] = Math.min(minArr[i - 1], nums[i]);
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > minArr[i]) {
                while (!stack.isEmpty() && stack.peek() <= minArr[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        
        return false;
    }
    
    /**
     * Searching intervals solution,
     * O(n^2) time, O(n) space complexity.
     * The idea is to store all rising intervals and to search for an index
     * within every interval where nums[index] > nums[start] and nums[index] > nums[end]
     */
    public boolean find132pattern_intervals(int[] nums) {
        List<int[]> intervals = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (start < i - 1) {
                    intervals.add(new int[] {nums[start], nums[i - 1]});
                }
                start = i;
            }
            
            for (int[] interval : intervals) 
                if (nums[i] > interval[0] && nums[i] < interval[1]) 
                    return true;
        }
        return false;
    }
    
    /**
     * Better than bruteforce solution,
     * O(n^2) time, O(1) space complexity.
     */
    public boolean find132pattern_betterThanBruteforce(int[] nums) {
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currMin = Math.min(currMin, nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (currMin < nums[j] && nums[j] < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Bruteforce solution (not accepted),
     * O(n^3) time, O(1) space complexity.
     */
    public boolean find132pattern_bruteforce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j])
                        return true;
                }
            }
        }
        return false;
    }   
    
    public static void main(String[] args) {
        Pattern132 sln = new Pattern132();
        System.out.println(sln.find132pattern(new int[] {1, 2, 3, 4}));
        System.out.println(sln.find132pattern(new int[] {3, 1, 4, 2}));
        System.out.println(sln.find132pattern(new int[] {-1, 3, 2, 0}));
    }

}
