// Given an array nums of n integers, are there elements a, b, c in nums 
// such that a + b + c = 0? Find all unique triplets in the array 
// which gives the sum of zero.
// The solution set must not contain duplicate triplets.
// See: https://leetcode.com/problems/3sum/

package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    // Almost brute force (accepted)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> triples = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -nums[i] - nums[j];
                if (s.contains(nums[j])) {
                    List<Integer> triple = Arrays.asList(new Integer[] { nums[i], third, nums[j] });
                    if (!triples.contains(triple))
                        triples.add(triple);
                } else s.add(third);
            }
        }
        
        return new ArrayList<List<Integer>>(triples);
    }

    public static void main(String[] args) {
        ThreeSum sln = new ThreeSum();
        System.out.println(sln.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(sln.threeSum(new int[] { -1, -1, -1, 1, 1, 1, 0, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { -1, 0, 0, 0, 0, 1, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 0, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 0, 0, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 1, 1, -2 }));
    }

}
