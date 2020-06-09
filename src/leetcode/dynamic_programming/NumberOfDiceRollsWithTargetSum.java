// You have d dice, and each die has f faces numbered 1, 2, ..., f.
// Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice 
// so the sum of the face up numbers equals target.
// See: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDiceRollsWithTargetSum {
    // TODO: Add Bottom-Up Dynamic Programming solution

    /**
     * Solution 1: Simple recursion with memorization - Top-Down Dynamic Programming
     */
    private final Map<Integer, Integer> memo = new HashMap<>();
    private final int mod = (int) (1e9 + 7);

    public int numRollsToTarget(int d, int f, int target) {
        if (target < 0 || (d == 0 && target > 0) || (d > 0 && target == 0))
            return 0;

        if (d == 0 && target == 0)
            return 1;

        int key = d * 1000 + target;
        if (memo.containsKey(key))
            return memo.get(key);

        long sum = 0;
        for (int i = 1; i <= f; i++)
            sum += numRollsToTarget(d - 1, f, target - i);

        memo.put(key, (int) (sum % mod));

        return (int) (sum % mod);
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(1, 6, 3)); // 1
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(2, 6, 7)); // 6
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(2, 5, 10)); // 2
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(1, 2, 3)); // 0
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(30, 30, 500));
    }

}
