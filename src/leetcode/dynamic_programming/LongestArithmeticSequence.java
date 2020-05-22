// Given an array A of integers, return the length of the longest arithmetic subsequence in A.
// See: https://leetcode.com/problems/longest-arithmetic-sequence/

package leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithmeticSequence {
    /**
     * Solution 1: Initial solution - Accepted.
     * TODO: The solution can be tuned for better performance
     */
    public int longestArithSeqLength(int[] A) {
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        dp.add(new HashMap<>());
        int max = 2;
        for (int i = 1; i < A.length; i++) {
            Map<Integer, Integer> currMap = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];

                if (dp.get(j).containsKey(diff)) {
                    int candidateForMax = dp.get(j).get(diff) + 1;
                    if (!currMap.containsKey(diff))
                        currMap.put(diff, candidateForMax);
                    
                    // int currMax = Math.max(currMap.get(diff), candidateForMax);
                    currMap.put(diff, candidateForMax);
                } else
                    currMap.put(diff, 2);
                
                max = Math.max(currMap.get(diff), max);
            }
            dp.add(currMap);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestArithmeticSequence sln = new LongestArithmeticSequence();
        System.out.println(sln.longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 }));
        System.out.println(sln.longestArithSeqLength(new int[] { 20, 1, 15, 3, 10, 5, 8 }));
        System.out.println(sln.longestArithSeqLength(new int[] { 83, 20, 17, 43, 52, 78, 68, 45 }));
    }

}
