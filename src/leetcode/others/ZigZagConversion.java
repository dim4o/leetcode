// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
// (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R

// See: https://leetcode.com/problems/zigzag-conversion/

package leetcode.others;

public class ZigZagConversion {
    /**
     * Relatively fast solution.
     * O(n) time
     * O(n) space
     */
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++)
            rows[i] = new StringBuilder();
        
        int i = 0;
        int row = 0;
        while (i < s.length()) {
            while (i < s.length() && row < numRows)
                rows[row++].append(s.charAt(i++));
            row -= 2;
            while (i < s.length() && row >= 0)
                rows[row--].append(s.charAt(i++));
            row+=2;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder currRow : rows)
            res.append(currRow);
        
        return res.toString();
    }

    /**
     * Initial Solution (stupid bruteforce).
     */
    public String convert_var1(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] str = s.toCharArray();
        char[][] arr = new char[numRows][s.length()];
        int i = 0;
        int row = 0;
        int col = 0;
        while (i < s.length()) {
            // print vertical
            while (i < s.length() && row < numRows)
                arr[row++][col] = str[i++];
            row -= 2;
            col++;
            // print diagonal
            while (i < s.length() && row >= 0)
                arr[row--][col++] = str[i++];
            col--;
            row += 2;
        }

        // Using the StringBuilder here doesn't gain a significant performance.
        // The solution is still slow.
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < numRows; i++)
            for (int j = 0; j < col + 1; j++)
                if (arr[i][j] != 0)
                    sb.append(arr[i][j]);

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion sln = new ZigZagConversion();

        System.out.println(sln.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(sln.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));

    }

    @SuppressWarnings("unused")
    private static void printRes(char[][] res) {
        for (int i = 0; i < res.length; i++) {
            String row = "";
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] != 0) {
                    row += res[i][j];
                } else {
                    row += " ";
                }
            }
            System.out.println(row);
        }
    }

}
