// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
// See: https://leetcode.com/problems/count-numbers-with-unique-digits/

package leetcode.math;

public class CountNumbersWithUniqueDigits {

    /**
     * Faster solution using some math combinatorics without backtracking.
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        if (n == 1)
            return 10;

        int curr = 9;
        for (int i = 9; i >= 9 - n + 2; i--)
            curr *= i;

        return curr + countNumbersWithUniqueDigits(n - 1);
    }

    /**
     * Backtracking solution solution.
     */
    private int count = 0;

    public int countNumbersWithUniqueDigits_backtrack(int n) {
        backtrack(n, new boolean[10], 0);
        return count;
    }

    private void backtrack(int maxLen, final boolean[] used, int len) {
        if (len > maxLen)
            return;

        count++;
        for (int i = 0; i < 10; i++) {
            if (!used[i] && (len > 0 || i > 0)) {
                used[i] = true;
                backtrack(maxLen, used, len + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(0));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(1));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(4));

    }

}
