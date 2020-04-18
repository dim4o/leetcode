// Design and implement a data structure for Least Recently Used (LRU) cache. It should support 
// the following operations: get and put.
//   - get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
//     otherwise return -1.
//   - put(key, value) - Set or insert the value if the key is not already present. When the cache 
//     reached its capacity, it should invalidate the least recently used item before inserting a new item.
// The cache is initialized with a positive capacity.
// Follow up:
// Could you do both operations in O(1) time complexity?
package leetcode.design;

import java.util.LinkedHashMap;
import java.util.Map;

// TODO: Add an another solution. The current solution works fine but the data structures and 
// the performance can be improved.
public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == capacity) {
            Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
            map.remove(entry.getKey());
        }
        if (map.containsKey(key))
            map.remove(key);
        
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        // test 1
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        cache.get(4);       // returns 4
        
        // test 2
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);
    }

}
