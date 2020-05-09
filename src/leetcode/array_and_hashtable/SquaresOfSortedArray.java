// Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
// See: https://leetcode.com/problems/squares-of-a-sorted-array/

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class SquaresOfSortedArray {
    /**
     * O(n) time, O(n) space.
     */
    public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length - 1;
        int idx = A.length - 1;
        int[] ans = new int[A.length];
        while (idx > -1) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                ans[idx--] = A[left] * A[left];
                left++;
            } else {
                ans[idx--] = A[right] * A[right];
                right--;
            }
        }

        return ans;
    }

    /**
     * Naive but easy solution. O(n.log(n)) time, O(1) space.
     */
    public int[] sortedSquares_var1(int[] A) {
        for (int i = 0; i < A.length; i++)
            A[i] *= A[i];
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray sln = new SquaresOfSortedArray();
        System.out.println(Arrays.toString(sln.sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
        System.out.println(Arrays.toString(sln.sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
    }

}
