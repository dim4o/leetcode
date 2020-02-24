// Given a collection of candidate numbers (candidates) and a target number (target), 
// find all unique combinations in candidates where the candidate numbers sums to target.
// Each number in candidates may only be used once in the combination.
// See: https://leetcode.com/problems/combination-sum-ii/

package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    private List<List<Integer>> ans = new LinkedList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        gen(candidates, target, new LinkedList<>(), 0);
        return ans;
    }

    private void gen(int[] candidates, int target, LinkedList<Integer> curr, int start) {
        if (target == 0) {
            ans.add(new LinkedList<>(curr));
        }
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                // !!! this "if" statement is essential
                // Because the array is sorted:
                // 1. all candidates that are greater then target are eliminated
                // 2. a candidate that is equal to the previous candidate is skipped !!!
                if (candidates[i] > target || i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                curr.add(candidates[i]);
                gen(candidates, target - candidates[i], curr, i + 1);
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(
                new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));

        System.out.println(new CombinationSum2().combinationSum2(
                new int[] { 2, 5, 2, 1, 2 }, 5));
    }

}
