// Given a collection of numbers that might contain duplicates, 
// return all possible unique permutations.
// See: https://leetcode.com/problems/permutations-ii/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Permutations2 {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Integer[] numbers = map.keySet().toArray(new Integer[0]);
        Integer[] freqs = map.values().toArray(new Integer[0]);

        perm(numbers, freqs, new LinkedList<Integer>(), nums.length);

        return ans;
    }

    private void perm(Integer[] nums, Integer[] freqs, LinkedList<Integer> currPerm, int size) {
        if (currPerm.size() == size) {
            ans.add(new LinkedList<>(currPerm));
            return;
        }

        for (int i = 0; i < nums.length; i++) 
            if (freqs[i] > 0) {
                freqs[i] -= 1;
                currPerm.add(nums[i]);
                perm(nums, freqs, currPerm, size);
                currPerm.removeLast();
                freqs[i] += 1;
            }
    }

    public static void main(String[] args) {
        Permutations2 sln = new Permutations2();
        System.out.println(sln.permuteUnique(new int[] { 1, 1, 2 }));
    }

}
