// Given an array of n positive integers and a positive integer s, 
// find the minimal length of a contiguous subarray of which the sum ≥ s. 
// If there isn't one, return 0 instead.
// See: https://leetcode.com/problems/minimum-size-subarray-sum/

package leetcode.others;

import java.util.Map;
import java.util.TreeMap;

public class MinimumSizeSubarraySum {
    // TODO: Implement O(N) time O(1) space solution
    // TreeMap solution with O(N.log(N)) time complexity and O(N) space
    public int minSubArrayLen(int s, int[] nums) {
        // create cumulative sums TreeMap (currSum -> index)
        int currSum = 0;
        TreeMap<Integer, Integer> cSumsMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i] + currSum;
            cSumsMap.put(currVal, i);
            currSum = currVal;
        }

        if (nums.length == 0 || s > cSumsMap.lastKey())
            return 0;

        cSumsMap.put(0, -1); // add initial sum 0 with -1 index

        int minLen = nums.length;
        for (int key : cSumsMap.keySet()) {
            if (key + s <= cSumsMap.lastKey()) {
                Map.Entry<Integer, Integer> pair = cSumsMap.ceilingEntry(key + s);
                minLen = Math.min(minLen, pair.getValue() - cSumsMap.get(key));
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum sln = new MinimumSizeSubarraySum();
        System.out.println(sln.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
        System.out.println(sln.minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(sln.minSubArrayLen(15, new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(sln.minSubArrayLen(5, new int[] { 2, 3, 1, 1, 1, 1, 1 }));
        System.out.println(sln.minSubArrayLen(3, new int[] { 1, 1 }));
    }

}
