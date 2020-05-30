// We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
// (Here, the distance between two points on a plane is the Euclidean distance.)
// You may return the answer in any order.  The answer is guaranteed to be unique 
// (except for the order that it is in.)
// See: https://leetcode.com/problems/k-closest-points-to-origin/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/

package leetcode.leetcode_challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    /**
     * Solution 3: Heap sort, Priority Queue solution. Not faster nor easier to
     * understand than Solution 2 but theoretically uses smaller memory because it keeps
     * only K element on the PQ.
     */
    public int[][] kClosest(int[][] points, int K) {
        // keep the the PQ in reverse order - max PQ instead min PQ
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p2, int[] p1) -> p1[0] * p1[0]
                + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);

        for (int[] point : points) {
            pq.add(point);
            // remove the larger element
            if (pq.size() > K)
                pq.poll();
        }

        int[][] ans = new int[K][2];
        while (K-- > 0)
            ans[K] = pq.poll();

        return ans;
    }

    /**
     * Solution 2: Heap sort, Priority Queue solution.
     */
    public int[][] kClosest_var2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> p1[0] * p1[0]
                + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);

        for (int[] point : points)
            pq.add(point);

        int[][] ans = new int[K][2];
        int i = 0;
        while (i < K)
            ans[i++] = pq.poll();

        return ans;
    }

    // TODO: There is faster "Divide and Conquer" solution. The idea is to split
    // the array in QuickSort manner - Quick Select. Uses the condition "You may
    // return the answer
    // in any order".

    /**
     * Solution 1: Simple sort, O(n.log(n)) time, O(n) space.
     */
    public int[][] kClosest_var1(int[][] points, int K) {
        Arrays.sort(points, (int[] p1, int[] p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0]
                - p2[1] * p2[1]);

        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {

    }

}
