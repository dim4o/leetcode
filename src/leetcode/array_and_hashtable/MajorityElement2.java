// Given an array of size n, find the majority element. The majority element is the element that appears 
// more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.
// See: https://leetcode.com/problems/majority-element/
// See: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3469/

package leetcode.array_and_hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 3)
                res.add(key);
        }

        return res;
    }

}
