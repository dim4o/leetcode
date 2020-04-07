// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
// Note that the row index starts from 0.
// See: https://leetcode.com/problems/pascals-triangle-ii/
// See: https://leetcode.com/problems/pascals-triangle-ii/discuss/567908/Java-Recursive-solution

package leetcode.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return new LinkedList<>(Arrays.asList(new Integer[] { 1 }));
        
        List<Integer> prevRow = getRow(rowIndex - 1);
        List<Integer> currRow = new LinkedList<>(Arrays.asList(new Integer[] { 1 }));

        for (int i = 0; i < prevRow.size() - 1; i++)
            currRow.add(prevRow.get(i) + prevRow.get(i + 1));
        currRow.add(1);;

        return currRow;
    }

    public static void main(String[] args) {
        PascalTriangle2 sln = new PascalTriangle2();
        System.out.println(sln.getRow(3));
        System.out.println(sln.getRow(5));
        System.out.println(sln.getRow(1));
        System.out.println(sln.getRow(0));
    }

}
