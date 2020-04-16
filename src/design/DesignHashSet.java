// Design a HashSet without using any built-in hash table libraries.
// To be specific, your design should include these functions:
//   - add(value): Insert a value into the HashSet. 
//   - contains(value) : Return whether the value exists in the HashSet or not.
//   - remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
// See: https://leetcode.com/problems/design-hashset/

package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {

    class MyHashSet {
        private List<List<Integer>> table;
        private int capacity = 16;
        private int size = 0;

        public MyHashSet() {
            table = new ArrayList<List<Integer>>(capacity);
            for (int i = 0; i < capacity; i++)
                table.add(new LinkedList<>());
        }

        public void add(int key) {
            table.get(key % capacity).add(key);
            size++;
            if ((float) size / capacity >= 0.75) {
                capacity *= 2;
                List<List<Integer>> newTable = new ArrayList<>(capacity);
                for (int i = 0; i < capacity; i++)
                    newTable.add(new LinkedList<>());
                for (List<Integer> list : table)
                    for (Integer element : list)
                        newTable.get(element % capacity).add(element);
                table = newTable;
            }
        }

        public void remove(int key) {
            table.get(key % capacity).removeIf(e -> e == key);
            size--;
        }

        public boolean contains(int key) {
            return table.get(key % capacity).contains(key);
        }
    }

    public static void main(String[] args) {

    }

}
