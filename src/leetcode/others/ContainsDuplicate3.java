// Given an array of integers, find out whether there are two distinct indices i and j in the array 
// such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference 
// between i and j is at most k.
// See: https://leetcode.com/problems/contains-duplicate-iii/

package leetcode.others;

public class ContainsDuplicate3 {
    // TODO: Add optimal solution

    /**
     * Almost brute force solution.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            int min = Math.min(nums.length, k + i + 1);
            for (int j = i + 1; j < min; j++)
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && j - i <= k)
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate3 sln = new ContainsDuplicate3();

        System.out.println(sln.containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));

        System.out.println(sln.containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2));

        System.out.println(sln.containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));

        System.out.println(
                sln.containsNearbyAlmostDuplicate(new int[] { -1, 2147483647 }, 1, 2147483647));
        // System.out.println(Math.abs(214748364 + 1));

    }

}
