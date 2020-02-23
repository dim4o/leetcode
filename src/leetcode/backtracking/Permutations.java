// Given a collection of distinct integers, return all possible permutations.
// See: https://leetcode.com/problems/permutations/

package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> result = new LinkedList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        genPerm(nums, new boolean[nums.length], new LinkedList<>());
        return result;
    }
    
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
        System.out.println(new Permutations().permute(new int[] {1, 2, 3}));
        System.out.println(new Permutations().permute(new int[] {1, 2}));
        System.out.println(new Permutations().permute(new int[] {1, 2, 3, 4}));
    }

}
