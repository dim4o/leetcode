// Write an efficient algorithm that searches for a value in an m x n matrix. 
// This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row
// See: https://leetcode.com/problems/search-a-2d-matrix/
// See: https://leetcode.com/problems/search-a-2d-matrix/discuss/571467/Java-Recursive-O(log(mn))-with-explanation

package leetcode.binary_search;

public class Search2DMatrix {

    /**
     * We can map every numbers from 0 to m.n - 1 to an element (i, j) from the matrix and vice versa 
     * with the following bijection: k -> (k / n, k % n), 
     * where k is a number in [0, m.n) and n is the number of the matrix columns. 
     * After this we can perform a straightforward binary search:
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        return search2D(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean search2D(int[][] matrix, int target, int l, int r) {
        if (l > r) return false;

        int mid = (l + r) / 2;
        int curr = matrix[mid / matrix[0].length][mid % matrix[0].length];
        if (target == curr)
            return true;
        else if (target > curr)
            return search2D(matrix, target, mid + 1, r);

        return search2D(matrix, target, l, mid - 1);
    }

    public static void main(String[] args) {
        Search2DMatrix sln = new Search2DMatrix();

        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

        System.out.println(sln.searchMatrix(matrix, 3));
        System.out.println(sln.searchMatrix(matrix, 23));
        System.out.println(sln.searchMatrix(matrix, 24));
    }

}
