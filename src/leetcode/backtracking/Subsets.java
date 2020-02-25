// Given a set of distinct integers, nums, return all possible subsets (the power set).
// Note: The solution set must not contain duplicate subsets.
// See: https://leetcode.com/problems/subsets/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        resultSet.add(new LinkedList<>()); // add an empty set
        backtrack(nums, resultSet, new LinkedList<>(), 0);
        return resultSet;
        
//        // recursive solution call
//        return recur(nums, nums.length);
    }
    
    @SuppressWarnings("unused")
    private void backtrack(int[] nums, List<List<Integer>> result, LinkedList<Integer> curr, int start) {
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            result.add(new LinkedList<>(curr));
            backtrack(nums, result, curr, i + 1);
            curr.removeLast();
        }
    }

    @SuppressWarnings("unused")
    private List<List<Integer>> recur(int[] nums, int end) {
        if (end == 0) {
            List<List<Integer>> emptyResult = new LinkedList<>();
            emptyResult.add(new LinkedList<Integer>());
            return emptyResult;
        }
        
        List<List<Integer>> resultSet = recur(nums, end - 1);
        
        int size = resultSet.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newSet = new LinkedList<>(resultSet.get(i));
            newSet.add(nums[end - 1]);
            resultSet.add(newSet);
        }
        
        return resultSet;
    }

    public static void main(String[] args) {
        Subsets sln = new Subsets();

        System.out.println(sln.subsets(new int[] { 1, 2, 3}));
        System.out.println(sln.subsets(new int[] { 1, 2, 3, 4}));
    }

}
