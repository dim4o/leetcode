// Given two arrays, write a function to compute their intersection.
// See: https://leetcode.com/problems/intersection-of-two-arrays/

package leetcode.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        set1.retainAll(set2);
        /*
         * It seems that the bellow conversion is much faster than: 
         * set1.stream().mapToInt(i -> i).toArray()
         */
        int[] ans = new int[set1.size()];
        int i = 0;
        for (int num : set1) 
            ans[i++] = num;

        return ans;
    }

    public int[] intersection_var3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> ans = new HashSet<Integer>();
        for (int num : nums1) set.add(num);
        for (int num : nums2)
            if (set.contains(num))
                ans.add(num);
            
        return ans.stream().mapToInt(i -> i).toArray();
    }

    // Solution with the build-in set API
    public int[] intersection_var2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        set1.retainAll(set2);

        return set1.stream().mapToInt(i -> i).toArray();
    }

    // Solution with the build-in binary search.
    public int[] intersection_var1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> ans = new HashSet<>();
        for (int num : nums2)
            if (Arrays.binarySearch(nums1, num) >= 0)
                ans.add(num);

        return ans.stream().mapToInt(i -> i).toArray();
    }

}
