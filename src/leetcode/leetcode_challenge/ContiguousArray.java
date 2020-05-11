// Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
// See: https://leetcode.com/problems/contiguous-array/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3298/
// See: https://leetcode.com/problems/contiguous-array/discuss/577436/Java-Simple-O(n)-Solution

package leetcode.leetcode_challenge;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    /**
     * O(n) time solution with HashMap
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ones = 0 , zeros = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++; else ones++;
            if (map.containsKey(zeros - ones))
                maxLen = Math.max(maxLen, i - map.get(zeros - ones));
            else
                map.put(zeros - ones, i);
        }
        
        return maxLen;
    }
    
    // Bruteforce with cache solution (not accepted due TLE).
    // O(n^2) time O(n) space
    public int findMaxLength_var1(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(-1, new int[] { 0, 0 });
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeros++;
            else
                ones++;

            map.put(i, new int[] { zeros, ones });
        }
        // System.out.println(map);
        // for (int key : map.keySet()) {
        //     System.out.println(String.format("%s -> %s", key, Arrays.toString(map.get(key))));
        // }

        int maxLen = 0;
        // int maxI = 0;
        // int maxJ = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int[] s = map.get(i - 1);
                int[] e = map.get(j);
                if (e[0] - s[0] == e[1] - s[1] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    // maxI = i;
                    // maxJ = j;
                }
            }
        }
        
        // System.out.println(String.format("(%s - %s)", maxI, maxJ));

        return maxLen;
    }

    public static void main(String[] args) {
        ContiguousArray sln = new ContiguousArray();

        System.out.println(sln.findMaxLength(new int[] { 0, 1 }));
        System.out.println(sln.findMaxLength(new int[] { 0, 1, 0 }));
        System.out.println(sln.findMaxLength(new int[] { 0, 1, 0, 1, 0, 0, 1 }));

    }

}
