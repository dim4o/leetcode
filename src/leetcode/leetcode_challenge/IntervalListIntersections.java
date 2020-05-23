// Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
// Return the intersection of these two interval lists.
// See: https://leetcode.com/problems/interval-list-intersections/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/

package leetcode.leetcode_challenge;

import java.util.Arrays;
import java.util.LinkedList;

public class IntervalListIntersections {
    /**
     * Solution 2 - Almost the same as Solution 1.
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        LinkedList<int[]> ans = new LinkedList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if (start <= end)
                ans.add(new int[] {start, end});
            
            if (A[i][1] > B[j][1]) j++;
            else i++;
        }

        return ans.toArray(new int[0][0]);
    }
    
    /**
     * Solution 1 - Initial solution - O(m + n) time O(m + n) space.
     */
    public int[][] intervalIntersection_var(int[][] A, int[][] B) {
        LinkedList<int[]> ans = new LinkedList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] > B[j][1]) {
                if (B[j][1] >= A[i][0])
                    ans.add(new int[] { Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1]) });
                j++;
            } else {
                if (A[i][1] >= B[j][0])
                    ans.add(new int[] { Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1]) });
                i++;
            }
        }

        return ans.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        IntervalListIntersections sln = new IntervalListIntersections();
        int[][] ans = sln.intervalIntersection(
                new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
                new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } });

        for (int[] a : ans)
            System.out.print(Arrays.toString(a) + ", ");
    }

}
