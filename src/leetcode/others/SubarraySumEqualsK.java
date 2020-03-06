// Given an array of integers and an integer k, you need to find 
// the total number of continuous subarrays whose sum equals to k.
// See: https://leetcode.com/problems/subarray-sum-equals-k/

package leetcode.others;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    // Optimized solution: O(N) time, O(N) space.
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // !Important
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (map.containsKey(currSum - k))
                count += map.get(currSum - k);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }

    // Brute force with optimization.
    // Time complexity O(N^2), O(N) space (accepted).
    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        // create a cumulative sum array
        int[] cSum = new int[nums.length + 1];
        for (int i = 1; i < cSum.length; i++)
            cSum[i] = cSum[i - 1] + nums[i - 1];
        
        for (int i = 0; i < cSum.length; i++) 
            for (int j = i + 1; j < cSum.length; j++)
                if (cSum[j] - cSum[i] == k)
                    ans++;

        return ans;
    }
    
    public static void main(String[] args) {
        SubarraySumEqualsK sln = new SubarraySumEqualsK();

        System.out.println(sln.subarraySum(new int[] { 1, 1, 1 }, 2)); // 2
        
        System.out.println(sln.subarraySum(new int[] { 1, 1, -3, 5, -2 }, 2)); // 3
        
        System.out.println(sln.subarraySum(new int[] { 1, 1, 1, 1, 1 }, 1)); // 5
        
        System.out.println(sln.subarraySum(new int[] { 0, 0, 0, 0 }, 0)); // 10
        
        System.out.println(sln.subarraySum(new int[] { -10, 1, -12, 2}, -10)); // 2
        
        System.out.println(sln.subarraySum(new int[] { 1}, 0)); // 0
        
        System.out.println(sln.subarraySum(new int[] { 1, 2, 3}, 3)); // 0
    }

}
