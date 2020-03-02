// Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
// The distance between two adjacent cells is 1.
// See: https://leetcode.com/problems/01-matrix/

package leetcode.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    // TODO: DP approach 
    public int[][] updateMatrixDP(int[][] matrix) {
        return null;
    }
    
    // BFS approach: Accepted
    public int[][] updateMatrix(int[][] matrix) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> q = new LinkedList<int[]>(); // keeps the positions
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    for (int[] dir : directions) {
                        int currI = dir[0] + i;
                        int currJ = dir[1] + j;
                        if (isAvailable(currI, currJ, used) && matrix[currI][currJ] == 0) {
                            q.add(new int[] {i, j, 1});
                            used[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        int prevLevelCount = q.size();
        
        while (!q.isEmpty()) {
            int count = 0;
            for (int i = 0; i < prevLevelCount; i++) {
                int[] curr = q.poll();
                int currI = curr[0];
                int currJ = curr[1];
                int level = curr[2];
                
                for (int[] dir : directions) {
                    int newI = dir[0] + currI;
                    int newJ = dir[1] + currJ;
                    if (isAvailable(newI, newJ, used) && matrix[newI][newJ] == 1) {
                        q.add(new int[] {newI, newJ, 1 + level});
                        count++;
                        matrix[newI][newJ] = level + 1;
                        used[newI][newJ] = true;
                    }
                }
            }
            prevLevelCount = count;
        }
        
        return matrix;
    }
    
    private boolean isAvailable(int i, int j, boolean[][] used) {
        return i < used.length && i >= 0 && j < used[0].length && j>=0 && !used[i][j];
    }

    // Slow and not optimal: Time limit Exceeded
    public int[][] updateMatrix1(int[][] matrix) {
        
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<int[]>();
                    boolean[][] used = new boolean[matrix.length][matrix[0].length];
                    q.add(new int[] {i, j, 0});
                    while (!q.isEmpty()) {
                        int[] curr  = q.poll();
                        int currI = curr[0];
                        int currJ = curr[1];
                        int level = curr[2];
                        used[currI][currJ] = true;
                        
                        if (matrix[currI][currJ] == 0) {
                            matrix[i][j] = level;
                            break;
                        }
                        
                        for (int[] dir : directions) {
                            int newI = currI + dir[0];
                            int newJ = currJ + dir[1];
                            if (newI >= 0 && newI < matrix.length &&
                                    newJ >= 0 && newJ < matrix[0].length &&
                                    !used[newI][newJ]) {
                                
                                
                                q.add(new int[] {newI, newJ, level + 1});
                            }
                        }
                    }
                    
                }
            }
        }
        
        return matrix;
    }

    public static void main(String[] args) {
        Matrix01 sln = new Matrix01();
        int[][] m1 = new int[][] { 
            { 0, 0, 0 }, 
            { 0, 1, 0 }, 
            { 0, 0, 0 } };
        int[][] m2 = new int[][] { 
            { 0, 0, 0 }, 
            { 0, 1, 0 }, 
            { 1, 1, 1 } };
            
        printTable(sln.updateMatrix(m1));
        System.out.println();
        printTable(sln.updateMatrix(m2));

    }
    
    private static void printTable(int[][] dp) {
        for (int[] line : dp) {
            System.out.println(Arrays.toString(line));
        }
    }

}
