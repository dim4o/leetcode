// Return all non-negative integers of length N such that the absolute difference between 
// every two consecutive digits is K.
// Note that every number in the answer must not have leading zeros except for the number 0 itself. 
// For example, 01 has one leading zero and is invalid, but 0 is valid.
// You may return the answer in any order.

// See: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
// See: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/

package leetcode.others;

import java.util.HashSet;
import java.util.Set;

public class NumbersWithSameConsecutiveDifferences {

    /**
     * Simple recursive DFS solution.
     */
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) 
            set.add(0);
        
        for (int i = 1; i < 10; i++)
            calc(N - 1, K, i);

//        System.out.println(set);

        return set.stream().mapToInt(Number::intValue).toArray();
    }

    Set<Integer> set = new HashSet<>();

    private void calc(int N, int K, int curr) {
        if (0 == N) {
            set.add(curr);
            return;
        }
        
        int lastPlus = curr % 10 + K;
        int lastMinis = curr % 10 - K;

        if (lastPlus < 10) 
            calc(N - 1, K, curr * 10 + lastPlus);
        
        if (lastMinis > -1)
            calc(N - 1, K, curr * 10 + lastMinis);
    }

    public static void main(String[] args) {
        new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(3, 7);
        new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(2, 1);
        new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(1, 1);
        new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(2, 0);
    }

}
