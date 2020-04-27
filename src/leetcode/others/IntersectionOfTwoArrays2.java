// Given two arrays, write a function to compute their intersection.
// See: https://leetcode.com/problems/intersection-of-two-arrays-ii/

package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    // Hash Table solution.
    // O(n + m) time.
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> ans = new ArrayList<Integer>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                int val = map.get(num);
                if (val > 0) {
                    map.put(num, --val);
                    ans.add(num);
                }
            }
        }

        int i = 0;
        int[] res = new int[ans.size()];
        for (int num : ans)
            res[i++] = num;

        return res;
    }
    
    // Solution with sorting.
    // ~ O(n.log(n) + m.log(m)) time.
    public int[] intersect_var(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<Integer>();
        
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                ans.add(nums1[i1]);
                i1++; i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else i2++;
        }

        int i = 0;
        int[] res = new int[ans.size()];
        for (int num : ans)
            res[i++] = num;

        return res;
    }
}
