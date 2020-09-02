// Given an array of 4 digits, return the largest 24 hour time that can be made.
// The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, 
// a time is larger if more time has elapsed since midnight.
// Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
// See: https://leetcode.com/problems/largest-time-for-given-digits/
// See: https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/

package leetcode.math;

import java.util.LinkedList;
import java.util.List;

public class LargestTimeForGivenDigits {
    /**
     * TODO: I think to generate permutations here is overkill and there is better
     * approach, but I have no time now and I just reused the permutations generator
     * from another problem. Maybe to generate permutations make sense for Python
     * because it has such generator that comes "out of the box".
     */
    public String largestTimeFromDigits(int[] A) {
        List<List<Integer>> perms = permute(A);
        int max = -1;
        for (List<Integer> perm : perms) {
            int curr = perm.get(0);
            for (int i = 1; i < 4; i++)
                curr = curr * 10 + perm.get(i);

            if (curr / 100 < 24 && curr % 100 < 60)
                max = Math.max(max, curr);
        }
        return max > -1 ? String.format("%02d:%02d", max / 100, max % 100) : "";
    }

    /**
     * Permutations generator
     */
    public List<List<Integer>> permute(int[] nums) {
        genPerm(nums, new boolean[nums.length], new LinkedList<>());
        return result;
    }

    private List<List<Integer>> result = new LinkedList<List<Integer>>();

    private void genPerm(int[] nums, boolean[] used, LinkedList<Integer> currPerm) {
        if (nums.length == currPerm.size()) {
            result.add(new LinkedList<>(currPerm));
            return;
        }

        for (int i = 0; i < nums.length; i++)
            if (!used[i]) {
                currPerm.add(nums[i]);
                used[i] = true;

                genPerm(nums, used, currPerm);

                currPerm.removeLast();
                used[i] = false;
            }
    }

    public static void main(String[] args) {
        System.out.println(
                new LargestTimeForGivenDigits().largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
        System.out.println(
                new LargestTimeForGivenDigits().largestTimeFromDigits(new int[] { 5, 5, 5, 5 }));
        System.out.println(
                new LargestTimeForGivenDigits().largestTimeFromDigits(new int[] { 0, 4, 0, 0 }));
        System.out.println(
                new LargestTimeForGivenDigits().largestTimeFromDigits(new int[] { 1, 9, 6, 0 }));
        System.out.println(
                new LargestTimeForGivenDigits().largestTimeFromDigits(new int[] { 2, 0, 6, 6 }));
        System.out.println(
                new LargestTimeForGivenDigits().largestTimeFromDigits(new int[] { 0, 0, 0, 0 }));
    }
}