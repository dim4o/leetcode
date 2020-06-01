// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
// See: https://leetcode.com/problems/triangle/

package leetcode.dynamic_programming;

import java.util.List;

public class Triangle {
    /**
     * Solution 1 - O(n^2) time, O(1) space
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(0));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j)
                            + triangle.get(i - 1).get(triangle.get(i).size() - 2));
                } else {
                    int curr = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j))
                            + triangle.get(i).get(j);
                    triangle.get(i).set(j, curr);
                }
            }
        }

        int lastRow = triangle.size() - 1;

        for (int i = 0; i < triangle.get(lastRow).size(); i++)
            min = Math.min(min, triangle.get(lastRow).get(i));

        return min;
    }

}
