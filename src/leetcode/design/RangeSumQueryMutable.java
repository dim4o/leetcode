// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
// The update(i, val) function modifies nums by updating the element at index i to val.
// See: https://leetcode.com/problems/range-sum-query-mutable/

package leetcode.design;

public class RangeSumQueryMutable {
    // TODO: Add Segment Tree solution
    // TODO: Add Sqrt Decomposition solution
    // See: https://www.youtube.com/watch?v=CWDQJGaN1gY
    // See: https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
    class NumArray {
        // Array representation of a Binary Indexed Tree
        private int[] biTree;
        private int[] nums;
    
        public NumArray(int[] nums) {
            this.nums = nums;
            biTree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                updateHelper(i, nums[i]);
            }
        }
        
        public void updateHelper(int i, int val) {
            i = i + 1;
            while (i <= nums.length) {
                biTree[i] += val;
                i += i & (-i); 
            }
        }
        
        public void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            updateHelper(i, diff);
        }
        
        private int getSum(int i) {
            int sum = 0;
            ++i;
            while (i > 0) {
                sum += biTree[i];
                i -= i & (-i);
            }
            return sum;
        }
        
        public int sumRange(int i, int j) {
            return getSum(j) - getSum(i - 1);
        }
    }

    public static void main(String[] args) {
        NumArray na = new RangeSumQueryMutable().new NumArray(new int[] {1, 3, 5});
        System.out.println(na.sumRange(0, 2));
//        System.out.println(na.sumRange(0, 1));
        na.update(1, 2);
        System.out.println(na.sumRange(0, 2));

    }

}
