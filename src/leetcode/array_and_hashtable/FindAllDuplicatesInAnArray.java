// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
// some elements appear twice and others appear once.
// Find all the elements that appear twice in this array.
// See: https://leetcode.com/problems/find-all-duplicates-in-an-array/

package leetcode.array_and_hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {
    // O(N) time, O(N) space solution, but faster
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
            if (used[nums[i] - 1])
                ans.add(nums[i]);
            else
                used[nums[i] - 1] = true;

        return ans;
    }

    // O(N) time, O(N) space solution
    public List<Integer> findDuplicates1(int[] nums) {
        Set<Integer> ans = new HashSet<Integer>();
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums)
            if (ans.contains(num))
                list.add(num);
            else
                ans.add(num);

        return list;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray sln = new FindAllDuplicatesInAnArray();
        System.out.println(sln.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

}
