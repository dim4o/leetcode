// Given a non-empty array of integers, return the k most frequent elements.
// See: https://leetcode.com/problems/top-k-frequent-elements/

package leetcode.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    
    // TODO: Try with Quick Select approach
    
    /**
     * Solution 2: Heap
     * Time: O(N.log(k))
     * Space: O(N)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((b,  a) -> map.get(b) - map.get(a));
        
        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }
        // Note: converting without a stream is much faster
        return pq.stream().mapToInt(i->i).toArray();
    }
    
    /*
     * Solution 1: Sort
     * Time: O(N.log(N))
     * Space: O(N)
     */
    public int[] topKFrequent_var1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> uniqueNums = new ArrayList<>(map.keySet());
        
        Collections.sort(uniqueNums, (a,  b) -> map.get(b) - map.get(a));
        
        // Note: converting without a stream is much faster
        return uniqueNums.subList(0, k).stream().mapToInt(i -> i).toArray();
    }
    
    public static void main(String[] args) {

    }

}
