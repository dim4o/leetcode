// Given an array A of non-negative integers, return an array consisting of all the even elements of A, 
// followed by all the odd elements of A.
// You may return any answer array that satisfies this condition.
// See: https://leetcode.com/problems/sort-array-by-parity/
// See: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
// See: https://leetcode.com/problems/sort-array-by-parity/discuss/803825/Java-O(1)-space-O(N)-time

package leetcode.array_and_hashtable;

import java.util.Arrays;

public class SortArrayByParity {

    /**
     * Two pointers solution, O(N) time, O(1) space (concise variant).
     */
    public int[] sortArrayByParity(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] % 2 == 1 && A[hi] % 2 == 0) {
                // swap the values
                int tmp = A[lo];
                A[lo++] = A[hi];
                A[hi--] = tmp;
            } else {
                if (A[lo] % 2 == 0) lo++;
                if (A[hi] % 2 == 1) hi--;
            }
        }

        return A;
    }
    
    /**
     * Two pointers solution, O(N) time, O(1) space.
     */
    public int[] sortArrayByParity_var1(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] % 2 == 0 && A[hi] % 2 == 1) {
                lo++; hi--;
            } else if (A[lo] % 2 == 0 && A[hi] % 2 == 0) {
                lo++;
            } else if (A[lo] % 2 == 1 && A[hi] % 2 == 1) {
                hi--;
            } else {
                // swap the values
                int tmp = A[lo];
                A[lo++] = A[hi];
                A[hi--] = tmp;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        SortArrayByParity sln = new SortArrayByParity();
        System.out.println(Arrays.toString(sln.sortArrayByParity(new int[] { 3, 1, 2, 4 })));
        System.out.println(
                Arrays.toString(sln.sortArrayByParity(new int[] { 1, 4, 6, 5, 3, 2, 1, 6, 9, 8 })));
    }

}
