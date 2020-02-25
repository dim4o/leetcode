// Given a collection of integers that might contain duplicates, nums, 
// return all possible subsets (the power set).
// Note: The solution set must not contain duplicate subsets.
// See: https://leetcode.com/problems/subsets-ii/

package leetcode.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Subsets2 {
    private List<List<Integer>> ans = new LinkedList<List<Integer>>();
    private Set<String> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        gen(nums, new LinkedList<>(), 0);
        return ans;
    }
    
    private void gen(int[] nums, LinkedList<Integer> curr, int pos) {
        ans.add(new LinkedList<Integer>(curr));
        
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            gen(nums, curr, i + 1);
            curr.removeLast();
        }
    }

    @SuppressWarnings("unused")
    private void gen2(int[] nums, LinkedList<Integer> curr, int pos) {
        if (!set.contains(curr.toString())) {
            ans.add(new LinkedList<Integer>(curr));
            set.add(curr.toString());
        }
        if (pos == nums.length) return;

        curr.add(nums[pos]);
        gen(nums, curr, pos + 1);
        curr.removeLast();
        gen(nums, curr, pos + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets2().subsetsWithDup(new int[] { 1, 1, 2 }));
        System.out.println(new Subsets2().subsetsWithDup(new int[] { 1, 2, 1, 2 }));
    }

}
