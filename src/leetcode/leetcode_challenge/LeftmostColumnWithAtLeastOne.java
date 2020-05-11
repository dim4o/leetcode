// (This problem is an interactive problem.)
// A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, 
// this row is sorted in non-decreasing order.
// Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. 
// If such index doesn't exist, return -1.
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/discuss/590632/Java-Two-solutions

package leetcode.leetcode_challenge;

import java.util.ArrayList;
import java.util.List;

public class LeftmostColumnWithAtLeastOne {
    
    // O(m + n)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int row = 0, col = cols - 1;
        int leftmost = cols;
        while (col >= 0 && row < rows)
            if (binaryMatrix.get(row, col) == 1) {
                leftmost = Math.min(leftmost, col);
                col--;
            } else
                row++;

        return leftmost < cols ? leftmost: -1;
    }
    
    // Binary Search: O(n.log(m))
    public int leftMostColumnWithOne_var1(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int leftmost = cols;
        for (int i = 0; i < rows; i++) {
            int curr = findLeftmostOne(binaryMatrix, i, cols, 0, cols - 1);
            if (curr > -1)
                leftmost = Math.min(leftmost, curr);
        }
        return leftmost < cols ? leftmost: -1;
    }
    
    private int findLeftmostOne(BinaryMatrix bm, int currRow, int cols, int l, int r) {
        if (l > r) return l < cols ? l : -1;
        int mid = (l + r) / 2;
        if (bm.get(currRow, mid) == 0)
            return findLeftmostOne(bm, currRow, cols, mid + 1, r);
        return findLeftmostOne(bm, currRow, cols, l, mid - 1);
    }

    public static void main(String[] args) {
        LeftmostColumnWithAtLeastOne sln = new LeftmostColumnWithAtLeastOne();
        int[][] matrix = new int[][] {
            {0, 0, 0, 1},
            {0, 0, 1, 1},
            {0, 1, 1, 1}
        };
        BinaryMatrix binaryMatrix = sln.new BinaryMatrix(matrix);
        System.out.println(sln.leftMostColumnWithOne(binaryMatrix));
    }
    
    class BinaryMatrix {
        private int[][] matrix;

        public BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int get(int x, int y) {
            return matrix[x][y];
        }

        public List<Integer> dimensions() {
            List<Integer> dimentions = new ArrayList<>();
            dimentions.add(matrix.length);
            dimentions.add(matrix[0].length);
            return dimentions;
        }
    }

}
