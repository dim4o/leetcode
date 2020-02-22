// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
// See: https://leetcode.com/problems/combinations/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        recur(n, k, 1, result, new LinkedList<>());
        return result;
    }
    
    public void recur(int n, int k, int start, List<List<Integer>> result, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            result.add(new LinkedList<>(curr));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            curr.add(i);
            recur(n, k, i + 1, result, curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations sln = new Combinations();
        
        System.out.println(sln.combine(4, 2));
    }

}
