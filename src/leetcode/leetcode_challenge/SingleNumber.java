// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
// Note: Your algorithm should have a linear runtime complexity. 
// Could you implement it without using extra memory?
// See: https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3283/

package leetcode.leetcode_challenge;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    // TODO: Find no extra space linear solution
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber sln = new SingleNumber();

        System.out.println(sln.singleNumber(new int[] { 2, 2, 1 }));
        System.out.println(sln.singleNumber(new int[] { 4, 1, 2, 1, 2 }));

    }

}
