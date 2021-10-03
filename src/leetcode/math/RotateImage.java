// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
// DO NOT allocate another 2D matrix and do the rotation.
// See: https://leetcode.com/problems/rotate-image/

package leetcode.math;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        final int max = 2_000;
        int n = matrix.length;
        
        for (int startI = 0; startI < n; startI++) {
            for (int startJ = 0; startJ < n; startJ++) {
                if (matrix[startI][startJ] <= 1000) {
                    int i = startI, j = startJ;
                    int mem = matrix[i][j];
                    for (int k = 0; k < 4; k++) {
                        int tmpJ = j;
                        j = n - 1 - i;
                        i = tmpJ;
                        
                        int tmp = matrix[i][j];
                        matrix[i][j] = mem + max;
                        mem = tmp;
                    }
                }
                matrix[startI][startJ]-= max;
            }
        }

        if (n % 2 != 0) 
            matrix[n/2][n/2] -= max;
    }

    public static void main(String[] args) {
        RotateImage sln = new RotateImage();

        int[][] m1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] m2 = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 },
                { 15, 14, 12, 16 } };
                
        printMatrix(m1);
        sln.rotate(m1);
        printMatrix(m1);
        
        printMatrix(m2);
        sln.rotate(m2);
        printMatrix(m2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }

}
