// Given an array w of positive integers, where w[i] describes the weight of index i, 
// write a function pickIndex which randomly picks an index in proportion to its weight.
// See: https://leetcode.com/problems/random-pick-with-weight/
// See: https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
// See: https://leetcode.com/problems/random-pick-with-weight/discuss/671540/JavaFast-and-Stupid

package leetcode.binary_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {
    /**
     * Solution 2 - Binary Search, smarter than Solution 1 but actually not faster.
     */
    class Solution {
        private final int[] w;
        private final Random rnd = new Random();

        public Solution(int[] w) {
            /*
             * Create cumulative weights array .
             * @see: https://docs.python.org/3/library/random.html#random.choices
             * Intuition: the lenghts of the ranges are proportional of the probability
             * so if the range is longer it is more likely to be picked.
             */
            for (int i = 1; i < w.length; i++)
                w[i] += w[i - 1];
            this.w = w;
        }

        public int pickIndex() {
            int target = rnd.nextInt(w[w.length - 1]) + 1;
            int left = 0, right = w.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target == w[mid])
                    return mid;
                if (target < w[mid])
                    right = mid;
                else
                    left = mid + 1;
            }

            return left;
        }
    }

    /**
     * Solution 1 - Simple, stupid but working with high performance.
     */
    class Solution1 {
        private final List<Integer> list = new ArrayList<>();
        private final Random rnd = new Random();

        public Solution1(int[] w) {
            int sum = 0;
            for (int el : w)
                sum += el;

            for (int i = 0; i < w.length; i++) {
                int count = (int) ((w[i] / (sum * 0.1d)) * 100);
                count = count == 0 ? 1 : count;

                for (int j = 0; j < count; j++)
                    list.add(i);
            }
        }

        public int pickIndex() {
            return list.get(rnd.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        Solution sln = new RandomPickWithWeight().new Solution(new int[] { 1, 3 });
        sln.pickIndex();

    }

}
