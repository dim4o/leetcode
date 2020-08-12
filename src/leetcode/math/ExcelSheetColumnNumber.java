// Given a column title as appear in an Excel sheet, return its corresponding column number.
// See: https://leetcode.com/problems/excel-sheet-column-number/
// See: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/

package leetcode.math;

public class ExcelSheetColumnNumber {
    /**
     * Very simple constant time solution with simple math trick.
     * Just convert the input from base(26) to base(10) number.
     */
    public int titleToNumber(String s) {
        int num = 0;
        int pow = 1;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            num += pow * (s.charAt(i) - 'A' + 1);
            pow *= 26;
        }
        return num;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber sln = new ExcelSheetColumnNumber();
        System.out.println(sln.titleToNumber("ZY"));
    }

}
