// Given a function  f(x, y) and a value z, return all positive integer pairs x and y where f(x,y) == z.
// See: https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

package leetcode.binary_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindPositiveIntegerSolutionforGivenEquation {
    /**
     * TODO: For further optimizations:
     * 
     * @see: https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/discuss/414249/JavaC%2B%2BPython-O(X%2BY)
     *       It seems that the problem is like:
     * @see leetcode.binary_search.Search2DMatrix2
     * @see: https://leetcode.com/problems/search-a-2d-matrix-ii/
     * @see: https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/572301/Java-Three-Solutions
     */

    /**
     * Solution 2 - Binary Search - O(n.log(n)) time, O(1) space (without the output
     * list).
     */
    public List<List<Integer>> findSolution_var2(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int x = 1; x <= 1000; x++) {
            int y = binarySearch(x, z, 1, 1000, customfunction);
            if (y > 0) {
                res.add(Arrays.asList(new Integer[] { x, y }));
            }
        }
        return res;
    }

    private int binarySearch(int x, int z, int l, int r, CustomFunction func) {
        if (l > r)
            return -1;

        int mid = (l + r) / 2;
        if (func.f(x, mid) > z)
            return binarySearch(x, z, l, mid - 1, func);
        else if (func.f(x, mid) < z)
            return binarySearch(x, z, mid + 1, r, func);
        return mid;
    }

    // This is the custom function interface.
    // You should not implement it, or speculate about its implementation
    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x + y;
        }
    }

    /**
     * Solution 1 Bruteforce - Accepted but slow. O(n^2) time, O(1) space (without
     * the output)
     */
    public List<List<Integer>> findSolution_var1(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = i; j < 1000; j++) {
                if (customfunction.f(i, j) == z)
                    res.add(Arrays.asList(new Integer[] { i, j }));
                if (i == j)
                    continue;
                if (customfunction.f(j, i) == z)
                    res.add(Arrays.asList(new Integer[] { j, i }));
            }
        }
        return res;
    }

}
