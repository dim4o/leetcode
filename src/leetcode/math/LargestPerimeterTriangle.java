// Given an array A of positive lengths, return the largest perimeter of a triangle 
// with non-zero area, formed from 3 of these lengths.
// If it is impossible to form any triangle of non-zero area, return 0.
// See: https://leetcode.com/problems/largest-perimeter-triangle/

package leetcode.math;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    // O(n.log(n)) time, O(1) space solution - accepted
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 1; i >= 2; i--)
            if (A[i - 1] + A[i - 2] > A[i])
                return A[i] + A[i - 1] + A[i - 2];

        return 0;
    }

    /**
     * Bruteforce O(n^3) time solution - not accepted(TLE)
     */
    public int largestPerimeter_var1(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++)
            for (int j = i + 1; j < A.length; j++)
                for (int k = j + 1; k < A.length; k++)
                    if (A[i] + A[j] > A[k] && A[i] + A[k] > A[j] && A[j] + A[k] > A[i])
                        max = Math.max(max, A[i] + A[j] + A[k]);

        return max;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle sln = new LargestPerimeterTriangle();
        System.out.println(sln.largestPerimeter(new int[] { 3, 2, 3, 4 }));
        System.out.println(sln.largestPerimeter(new int[] { 2, 1, 2 }));
        System.out.println(sln.largestPerimeter(new int[] { 3, 6, 2, 3 }));
        System.out.println(sln.largestPerimeter(new int[] { 1, 2, 1 }));
    }

}
