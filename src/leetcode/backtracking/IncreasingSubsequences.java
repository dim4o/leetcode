// Given an integer array, your task is to find all the different possible increasing subsequences 
// of the given array, and the length of an increasing subsequence should be at least 2.
// See: https://leetcode.com/problems/increasing-subsequences/

package leetcode.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
  
    /**
     * Simple but not very fast solution.
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> totalRes = new HashSet<>();
        
        helper(nums, 0, new LinkedList<>(), totalRes);

        return new LinkedList<List<Integer>>(totalRes);
    }
    
    private void helper(int[] nums, int start, LinkedList<Integer> currRes, Set<List<Integer>> totalRes) {
        if (currRes.size() >= 2) 
            totalRes.add(new LinkedList<>(currRes));
        
        for (int i = start; i < nums.length; i++) {
            if (currRes.isEmpty() || currRes.peekLast() <= nums[i]) {
                currRes.add(nums[i]);
                helper(nums, i + 1, currRes, totalRes);
                currRes.removeLast();
            }
        }
    }

    /**
     * Brute force DFS solution (accepted).
     * TODO: add faster solution.
     */
    private Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> findSubsequences_var1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            LinkedList<Integer> curr = new LinkedList<>();
            curr.add(nums[i]);
            dfs(nums, i, curr);
        }

        return new LinkedList<>(ans);
    }

    private void dfs(int nums[], int start, LinkedList<Integer> curr) {
        if (start == nums.length) 
            return;
        
        if (curr.size() >= 2) 
            ans.add(new LinkedList<>(curr));

        for (int i = start + 1; i < nums.length; i++) {
            if (nums[start] <= nums[i]) {
                curr.add(nums[i]);
                dfs(nums, i, curr);
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        IncreasingSubsequences sln = new IncreasingSubsequences();

        System.out.println(sln.findSubsequences(new int[] { 4, 6, 7, 7 }));
//        
        System.out.println(sln.findSubsequences(new int[] { 4, 3, 2, 1 }));
        
        System.out.println(sln.findSubsequences(new int[] { 1, 4, 3 }));
    }

}
