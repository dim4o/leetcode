// Design a class to find the kth largest element in a stream. 
// Note that it is the kth largest element in the sorted order, 
// not the kth distinct element.
// See: https://leetcode.com/problems/kth-largest-element-in-a-stream/

package leetcode.others;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInStream {
    // For an elegant solution see: 
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/540908/Java-HEAP-nums-array-wired-though
    class KthLargest {
        private Queue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.pq = new PriorityQueue<Integer>();
            this.k = k;
            for (int i : nums)
                pq.add(i);

            for (int i = 0; i < nums.length - k; i++)
                pq.poll();
        }

        public int add(int val) {
            if (pq.size() == k - 1) {
                pq.add(val);
                return pq.peek();
            }
            if (val >= pq.peek()) {
                pq.add(val);
                pq.poll();
            }

            return pq.peek();
        }

    }

    public static void main(String[] args) {
        KthLargestElementInStream sln = new KthLargestElementInStream();

        KthLargest kth1 = sln.new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kth1.add(3));
        System.out.println(kth1.add(5));
        System.out.println(kth1.add(10));
        System.out.println(kth1.add(9));
        System.out.println(kth1.add(4));
        System.out.println();

        KthLargest kth2 = sln.new KthLargest(1, new int[] {});
        System.out.println(kth2.add(-3));
        System.out.println(kth2.add(-2));
        System.out.println(kth2.add(-4));
        System.out.println(kth2.add(0));
        System.out.println(kth2.add(4));
        System.out.println();

        KthLargest kth3 = sln.new KthLargest(2, new int[] { 0 });
        System.out.println(kth3.add(-1));
        System.out.println(kth3.add(1));
        System.out.println(kth3.add(-2));
        System.out.println(kth3.add(-3));
        System.out.println(kth3.add(3));
        System.out.println();

        KthLargest kth4 = sln.new KthLargest(7, new int[] { -10, 1, 3, 1, 4, 10, 3, 9, 4, 5, 1 });
        System.out.println(kth4.add(3));
        System.out.println(kth4.add(2));
        System.out.println(kth4.add(3));
        System.out.println(kth4.add(1));
        System.out.println(kth4.add(2));
        System.out.println(kth4.add(4));
        System.out.println(kth4.add(5));
        System.out.println(kth4.add(5));
    }

}
