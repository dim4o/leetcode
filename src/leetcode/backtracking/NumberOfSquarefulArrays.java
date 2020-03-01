// Given an array A of non-negative integers, the array is squareful 
// if for every pair of adjacent elements, their sum is a perfect square.
// Return the number of permutations of A that are squareful.  
// Two permutations A1 and A2 differ if and only if there is some index i 
// such that A1[i] != A2[i].
// See: https://leetcode.com/problems/number-of-squareful-arrays/

package leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSquarefulArrays {
    private int count = 0;

    public int numSquarefulPerms(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) map.put(i, 1 + map.getOrDefault(i, 0));
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Integer[] freqs = map.values().toArray(new Integer[0]);
        perm(keys, freqs, -1, A.length, 0);
        return count;
    }

    public void perm(Integer[] keys, Integer[] freqs, int res, int n, int start) {
        if (start == n) {
            count++;
            return;
        }

        for (int i = 0; i < keys.length; i++)
            if (freqs[i] != 0) {
                boolean isSquare = false;
                if (res != -1) {
                    Double sqrt = Math.sqrt(res + keys[i]);
                    isSquare = sqrt.intValue() == sqrt;
                }
                if (isSquare || res == -1) {
                    freqs[i]--;
                    perm(keys, freqs, keys[i], n, start + 1);
                    freqs[i]++;
                }
            }
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSquarefulArrays().numSquarefulPerms(new int[] { 65, 44, 5, 11 }));
        System.out.println(new NumberOfSquarefulArrays().numSquarefulPerms(new int[] { 1, 17, 8 }));
        System.out.println(new NumberOfSquarefulArrays().numSquarefulPerms(new int[] { 2, 2, 2 }));
    }

}
