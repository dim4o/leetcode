// We have a collection of stones, each stone has a positive integer weight.
// Each turn, we choose the two heaviest stones and smash them together. 
// Suppose the stones have weights x and y with x <= y.  The result of this smash is:
//   If x == y, both stones are totally destroyed;
//   If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
// At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
// See: https://leetcode.com/problems/last-stone-weight/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
// See: https://leetcode.com/problems/last-stone-weight/discuss/575581/Java-O(n)-Time-Solution

package leetcode.others;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    /**
     * O(n) solution with Counting sort solution;
     */
    public int lastStoneWeight(int[] stones) {
        int max = 0;
        final int size = 1000;
        int len = stones.length;
        int[] sorted = new int[size];
        for (int stone : stones) {
            max = Math.max(max, stone);
            sorted[stone % size]++;
        }
        
        int st1 = max, st2 = max;
        while (len > 1) {
            // stone 1
            while (st1 >= 0 && sorted[st1] == 0) st1--;
            sorted[st1]--;
            len--;
            // stone 2
            st2 = st1;
            while (st2 >= 0 && sorted[st2] == 0) st2--;
            sorted[st2]--;
            len--;
            
            if (st1 > st2) {
                sorted[(st1 - st2) % size]++;
                len++;
            }
        }
        
        for (int i = 0; i <= st1; i++)
            if (sorted[i] == 1) return i;
 
        return 0;
    }

    /**
     * Heap solution.
     */
    public int lastStoneWeight_var1(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int stone : stones)
            heap.add(stone);

        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();
            if (x < y) heap.add(y - x);
        }

        return heap.size() > 0 ? heap.peek() : 0;
    }

    public static void main(String[] args) {
        LastStoneWeight sln = new LastStoneWeight();
        System.out.println(sln.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
        System.out.println(sln.lastStoneWeight(new int[] { 8, 10, 4 }));
        System.out.println(sln.lastStoneWeight(new int[] { 1 }));
    }

}
