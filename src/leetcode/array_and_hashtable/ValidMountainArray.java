// Given an array A of integers, return true if and only if it is a valid mountain array.
// See: https://leetcode.com/problems/valid-mountain-array/

package leetcode.array_and_hashtable;

public class ValidMountainArray {
    // O(n) time, O(1) space.
    public boolean validMountainArray(int[] A) {
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1])
            i++;

        if (i == A.length - 1 || i == 0)
            return false;

        while (i < A.length - 1 && A[i] > A[i + 1])
            i++;

        return i == A.length - 1;
    }

    public static void main(String[] args) {
        ValidMountainArray sln = new ValidMountainArray();
        System.out.println(sln.validMountainArray(new int[] { 2, 1 }));
        System.out.println(sln.validMountainArray(new int[] { 3, 5, 5 }));
        System.out.println(sln.validMountainArray(new int[] { 0, 3, 2, 1 }));

    }

}
