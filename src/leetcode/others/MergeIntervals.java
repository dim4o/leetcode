// Given a collection of intervals, merge all overlapping intervals.
// See: https://leetcode.com/problems/merge-intervals/

package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /**
     * O(n) time.
     * O(1) space (or O(n) - depends of the implementation).
     *  
     * Note: there is a different approach to the problem.
     * The intervals can be represented as nodes of a graph and the edges
     * will connect the overlapping intervals. Then we can use DFS to find the 
     * connected components and to build the output. Moreover that this approach
     * seems interesting it's time complexity is worst: O(n^2).
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            ans.add(new int[] { start, end });
            i++;
        }

        return ans.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        MergeIntervals sln = new MergeIntervals();
        sln.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });

        sln.merge(new int[][] { { 1, 3 }, { 5, 10 }, { 2, 3 }, { 3, 4 }, {4, 4}});
    }

}
