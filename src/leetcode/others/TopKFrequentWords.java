// Given a non-empty list of words, return the k most frequent elements.
// Your answer should be sorted by frequency from highest to lowest. 
// If two words have the same frequency, then the word with the lower alphabetical order comes first.
// See: https://leetcode.com/problems/top-k-frequent-words/

package leetcode.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    
    /**
     * Solution 2: Keeps K element in Heap/PriorityQueue.
     * Time complexity: O(n(log(k))) (better than O(n.log(n)))
     * Space complexity: O(n)
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>((b, a) -> {
            if (map.get(a) != map.get(b))
                return map.get(b) - map.get(a);

            return a.compareTo(b);
        });
        
        for (String word : map.keySet()) {
            pq.add(word);
            if (pq.size() > k)
                pq.poll();
        }
        
        // !Important - be careful when converting Heap/PriorityQueue to list.
        // It guarantee smallest/largest element when `poll()` 
        // but when iterate the order is not guaranteed.
        LinkedList<String> ans = new LinkedList<>();
        while (!pq.isEmpty())
            ans.addFirst(pq.poll());
            
        return ans;
    }
    
    /**
     * Solution 1: Simple sorting solution: Accepted 
     * Time complexity: O(n.log(n))
     * Space complexity: O(n)
     */
    public List<String> topKFrequent_var1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        List<String> uniqueWords = new ArrayList<>(map.keySet());

        Collections.sort(uniqueWords, (a, b) -> {
            if (map.get(a) != map.get(b))
                return map.get(b) - map.get(a);

            return a.compareTo(b);
        });
        return uniqueWords.subList(0, k);
    }

    public static void main(String[] args) {
        TopKFrequentWords sln = new TopKFrequentWords();
        System.out.println(sln.topKFrequent(new String[] {"b", "b", "b", "a", "a", "a"},  2));

    }

}
