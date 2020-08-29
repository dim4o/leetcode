// Given an array of integers A, We need to sort the array performing a series of pancake flips.
// In one pancake flip we do the following steps:
//   - Choose an integer k where 0 <= k < A.length.
//   - Reverse the sub-array A[0...k].
// See: https://leetcode.com/problems/pancake-sorting/
// See: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3441/

package leetcode.others;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();

        for (int i = A.length - 1; i > 0; i--) {
            int k = findMax(A, i);
            if (k > 0) {
                ans.add(k + 1);
                reverse(A, k);
            }
            ans.add(i + 1);
            reverse(A, i);
        }

        return ans;
    }

    private int findMax(int[] A, int k) {
        int max = 0;
        for (int i = 0; i <= k; i++)
            if (A[i] > A[max])
                max = i;
        return max;
    }

    private void reverse(int[] A, int k) {
        int i = 0;
        while (i < k) {
            int tmp = A[i];
            A[i++] = A[k];
            A[k--] = tmp;
        }
    }

    public static void main(String[] args) {
        PancakeSorting sln = new PancakeSorting();

        int[] A = { 3, 2, 4, 1 };
        System.out.println(sln.pancakeSort(A));
    }

}
