// Find all possible combinations of k numbers that add up to a number n, 
// given that only numbers from 1 to 9 can be used and each combination 
// should be a unique set of numbers.
// See: https://leetcode.com/problems/combination-sum-iii/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    private List<List<Integer>> ans = new LinkedList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int targetSum = n;
        if (n > 10)
            n = 9;
        gen(k, n, targetSum, new LinkedList<>(), 0);
        return ans;
    }

    private void gen(int k, int n, int target, LinkedList<Integer> curr, int pos) {
        if (curr.size() == k) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if (target > 0) {
            for (int i = pos; i < n; i++) {
                curr.add(i + 1);
                gen(k, n, target - i - 1, curr, i + 1);
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 7));
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }

}
