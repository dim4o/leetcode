// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
// See: https://leetcode.com/problems/pascals-triangle/
// See: https://leetcode.com/problems/pascals-triangle/discuss/567886/Java-Fast-recursive-solution

package leetcode.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 2) {
            List<List<Integer>> ans = new LinkedList<List<Integer>>();
            if (numRows == 1)
                ans.add(new LinkedList<>(Arrays.asList(new Integer[] { 1 })));
            return ans;
        }

        List<List<Integer>> res = generate(numRows - 1);
        List<Integer> prevRow = res.get(res.size() - 1);
        List<Integer> currRow = new LinkedList<>(Arrays.asList(new Integer[] { 1 }));

        for (int i = 0; i < prevRow.size() - 1; i++)
            currRow.add(prevRow.get(i) + prevRow.get(i + 1));
        currRow.add(1);
        res.add(currRow);

        return res;
    }

    public static void main(String[] args) {
        PascalTriangle sln = new PascalTriangle();
        System.out.println(sln.generate(5));
        System.out.println(sln.generate(1));
        System.out.println(sln.generate(0));
    }

}
