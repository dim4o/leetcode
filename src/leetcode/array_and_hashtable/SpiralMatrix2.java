// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
// See: https://leetcode.com/problems/spiral-matrix-ii/

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class SpiralMatrix2 {
    
    public int[][] generateMatrix(int n) {
        int[][] M = new int[n][n];

        int i = 0, j = 0;
        int num = 1;
        while (num <= n * n) {
            while (j < M[0].length && M[i][j] == 0) M[i][j++] = num++;
            i++; j--; 
            
            while (i < M.length && M[i][j] == 0) M[i++][j] = num++;
            i--; j--; 
            
            while (j >= 0 && M[i][j] == 0) M[i][j--] = num++;
            
            i--; j++; 
            
            while (i >= 0 && M[i][j] == 0) M[i--][j] = num++;
            i++; j++;
        }
        
        return M;
    }
    
    public static void main(String[] args) {
        SpiralMatrix2 sln = new SpiralMatrix2();
        
        int[][] M  = sln.generateMatrix(3);
        
        for (int[] m : M) {
            System.out.println(Arrays.toString(m));
        }
    }

}
