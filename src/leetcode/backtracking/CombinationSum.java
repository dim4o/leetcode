// Given a set of candidate numbers (candidates) (without duplicates) 
// and a target number (target), find all unique combinations in candidates 
// where the candidate numbers sums to target.
// The same repeated number may be chosen from candidates unlimited number of times.
// See: https://leetcode.com/problems/combination-sum/

package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> ans = new LinkedList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        gen(candidates, target, new LinkedList<>(), 0);
        return ans;
    }

    private void gen(int[] candidates, int target, LinkedList<Integer> curr, int pos) {
        if (target == 0) {
            ans.add(new LinkedList<Integer>(curr));
            return;
        }
        if (target > 0) {
            for (int i = pos; i < candidates.length; i++) {
                curr.add(candidates[i]);
                gen(candidates, target - candidates[i], curr, i);
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(new CombinationSum().combinationSum(new int[] { 2, 3, 5 }, 8));
        System.out.println(new CombinationSum().combinationSum(new int[] { 1 }, 8));
        System.out.println(new CombinationSum().combinationSum(new int[] { 3 }, 8));
    }

}
