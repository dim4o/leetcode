// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
// See: https://leetcode.com/problems/spiral-matrix/

package leetcode.array_and_hashtable;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    private final int val = Integer.MIN_VALUE;
    public List<Integer> spiralOrder(int[][] M) {

        List<Integer> ans = new LinkedList<>();
        if (M == null || M.length == 0)
            return ans;
       
        int i = 0, j = 0;
        
        while (ans.size() < M.length * M[0].length) {
            while (j < M[0].length) {
                if (M[i][j] == val)
                    break;
                ans.add(M[i][j]);
                M[i][j++] = val;
            }
            i++; j--; 
            
            while (i < M.length) {
                if (M[i][j] == val)
                    break;
                ans.add(M[i][j]);
                M[i++][j] = val;
            }
            i--; j--; 
            
            while (j >= 0) {
                if (M[i][j] == val)
                    break;
                ans.add(M[i][j]);
                M[i][j--] = val;
            }
            i--; j++; 
            
            while (i >= 0) {
                if (M[i][j] == val)
                    break;
                ans.add(M[i][j]);
                M[i--][j] = val;
            }
            i++; j++;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        SpiralMatrix sln = new SpiralMatrix();
        
        System.out.println(sln.spiralOrder(new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 },
        }));
        System.out.println(sln.spiralOrder(new int[][] {
            { 1, 2, 3, 4},
            { 5, 6, 7, 8},
            { 9, 10, 11, 12 },
        }));
        
    }
}
