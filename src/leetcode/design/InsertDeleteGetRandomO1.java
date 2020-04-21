// Design a data structure that supports all following operations in average O(1) time.
//   - insert(val): Inserts an item val to the set if not already present.
//   - remove(val): Removes an item val from the set if present.
//   - getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
// See: https://leetcode.com/problems/insert-delete-getrandom-o1/

package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    
    // TODO: There is may be a faster alternative - try to find it.
    class RandomizedSet {
        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> valToIdx = new HashMap<>();
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain
         * the specified element.
         */
        public boolean insert(int val) {
            if (!valToIdx.containsKey(val)) {
                valToIdx.put(val, nums.size());
                nums.add(val);
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified
         * element.
         */
        public boolean remove(int val) {
            if (valToIdx.containsKey(val)) {
                int idx = valToIdx.get(val);
                int lastVal = nums.get(nums.size() - 1);
                
                nums.set(idx, lastVal);
                valToIdx.put(lastVal, idx);
                
                nums.remove(nums.size() - 1);
                valToIdx.remove(val);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet rs = new InsertDeleteGetRandomO1().new RandomizedSet();
        
        rs.insert(0);
        rs.insert(1);
        rs.remove(0);
        rs.insert(2);
        rs.remove(1);
        System.out.println(rs.getRandom());

    }

}
