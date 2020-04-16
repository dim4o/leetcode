// Design a HashMap without using any built-in hash table libraries.
// To be specific, your design should include these functions:
//   - put(key, value) : Insert a (key, value) pair into the HashMap. 
//     If the value already exists in the HashMap, update the value.
//   - get(key): Returns the value to which the specified key is mapped, 
//     or -1 if this map contains no mapping for the key.
//   - remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
// See: https://leetcode.com/problems/design-hashmap/

package leetcode.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap {
    class MyHashMap {
        private List<LinkedList<int[]>> table;
        private int capacity = 16;
        private int size = 0;

        public MyHashMap() {
            table = new ArrayList<LinkedList<int[]>>(capacity);
            for (int i = 0; i < capacity; i++)
                table.add(new LinkedList<int[]>());
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = key % capacity;
            boolean found = false;
            for (int[] pair : table.get(index))
                if (pair[0] == key) {
                    pair[1] = value;
                    found = true;
                    break;
                }
            if (!found)
                table.get(index).add(new int[] { key, value });
            size++;

            if ((float) size / capacity >= 0.75) {
                capacity *= 2;
                List<LinkedList<int[]>> newTable = new ArrayList<>(capacity);
                for (int i = 0; i < capacity; i++)
                    newTable.add(new LinkedList<int[]>());
                for (LinkedList<int[]> pairs : table)
                    for (int[] pair : pairs)
                        newTable.get(pair[0] % capacity).add(pair);
                table = newTable;
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map
         * contains no mapping for the key
         */
        public int get(int key) {
            for (int[] pair : table.get(key % capacity))
                if (pair[0] == key)
                    return pair[1];
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping
         * for the key
         */
        public void remove(int key) {
            int index = key % capacity;
            LinkedList<int[]> list = table.get(index);
            for (int[] pair : list)
                if (pair[0] == key) {
                    list.remove(pair);
                    size--;
                    break;
                }
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
     * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
     * obj.remove(key);
     */
    public static void main(String[] args) {
        MyHashMap hashMap = new DesignHashMap().new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1)); // returns 1
        System.out.println(hashMap.get(3)); // returns -1 (not found)
        hashMap.put(2, 1); // update the existing value
        System.out.println(hashMap.get(2)); // returns 1
        hashMap.remove(2); // remove the mapping for 2
        System.out.println(hashMap.get(2)); // returns -1 (not found)
    }
}
