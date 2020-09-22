// Given an array of size n, find the majority element. The majority element is the element that appears 
// more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.
// See: https://leetcode.com/problems/majority-element/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/

package leetcode.array_and_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /**
     * Sort solution. Actually this is faster than the HashMap solution although the
     * worst O(n.log(n) time).
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    /**
     * One pass HashMap solution, O(n) time, O(n) space.
     */
    public int majorityElement_var2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            if ( count > nums.length / 2) {
                return num;
            } else {
                countMap.put(num, count);
            }
        }

        return -1;
    }

    /**
     * Initial solution, O(n) time, O(n) space.
     */
    public int majorityElement_var1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        for (int num : countMap.keySet())
            if (countMap.get(num) > nums.length / 2)
                return num;

        return -1;
    }

}
