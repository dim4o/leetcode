// An image is represented by a 2-D array of integers, each integer representing the pixel value of the image 
// (from 0 to 65535).
// Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
// and a pixel value newColor, "flood fill" the image.
// To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally 
// to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally 
// to those pixels (also with the same color as the starting pixel), and so on. 
// Replace the color of all of the aforementioned pixels with the newColor.
// At the end, return the modified image.
// See: https://leetcode.com/problems/flood-fill/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/

package leetcode.leetcode_challenge;

import java.util.Arrays;

public class FloodFill {

    private final int[][] directions = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        /**
         * Be careful when changing in-place values during a DFS!
         */
        if (image[sr][sc] != newColor)
            dfs(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int newColor, int oldColor) {
        image[row][col] = newColor;
        for (int i = 0; i < directions.length; i++) {
            int newRow = directions[i][0] + row;
            int newCol = directions[i][1] + col;
            if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
                    && image[newRow][newCol] == oldColor)
                dfs(image, newRow, newCol, newColor, oldColor);
        }
    }

    public static void main(String[] args) {
        FloodFill sln = new FloodFill();

        int[][] image1 = sln.floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1,
                2);
        int[][] image2 = sln.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1);

        for (int[] row : image1)
            System.out.println(Arrays.toString(row));
        System.out.println();
        for (int[] row : image2)
            System.out.println(Arrays.toString(row));

    }

}
