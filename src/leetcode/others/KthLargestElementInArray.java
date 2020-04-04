// Find the kth largest element in an unsorted array. 
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// See: https://leetcode.com/problems/kth-largest-element-in-an-array/

package leetcode.others;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }

    /**
     * Naive but actually fast initial solution.
     */
    public int findKthLargest_var1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
