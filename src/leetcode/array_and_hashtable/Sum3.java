// Given an array nums of n integers, are there elements a, b, c in nums 
// such that a + b + c = 0? Find all unique triplets in the array 
// which gives the sum of zero.
// The solution set must not contain duplicate triplets.
// See: https://leetcode.com/problems/3sum/

package leetcode.array_and_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {
    // Two pointers solution (accepted)
    // Moreover the O(n.log(n) + n^2) time complexity this solution is faster than the others,
    // because no need of Set
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triples = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triples.add(Arrays.asList(new Integer[] { nums[i], nums[left], nums[right] }));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triples;
    }

    // Sort and memorize (accepted)
    public List<List<Integer>> threeSum2(int[] nums) {
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
                } else
                    s.add(third);
            }
        }

        return new ArrayList<List<Integer>>(triples);
    }

    // Without sort O(n^2) time (accepted)
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<Integer> used = new HashSet<>();
        Set<List<Integer>> triples = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (!used.contains(nums[j])) {
                    int third = -nums[i] - nums[j];
                    if (s.contains(nums[j])) {
                        List<Integer> triple = Arrays
                                .asList(new Integer[] { nums[i], third, nums[j] });
                        if (!triples.contains(triple))
                            triples.add(triple);
                    } else
                        s.add(third);
                }
            }
            used.add(nums[i]);
        }

        return new ArrayList<List<Integer>>(triples);
    }

    public static void main(String[] args) {
        Sum3 sln = new Sum3();
        System.out.println(sln.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(sln.threeSum(new int[] { -1, -1, -1, 1, 1, 1, 0, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { -1, 0, 0, 0, 0, 1, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 0, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 0, 0, 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 0, 0 }));
        System.out.println(sln.threeSum(new int[] { 1, 1, -2 }));
    }

}
