// Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
// Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
//   - 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
//   - F.length >= 3;
//   - and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
// Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, 
// except if the piece is the number 0 itself.
// Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
// See: https://leetcode.com/problems/split-array-into-fibonacci-sequence/
// Connected problem: https://leetcode.com/problems/additive-number/

package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    /**
     * Iterative non-backtracking solution. Moreover that this problem is labeled as
     * "Backtracking" I didn't find using a backtracking here as very intuitive.
     */
    // TODO: Try to find easier and intuitive backtracking solution.
    public List<Integer> splitIntoFibonacci(String S) {
        char[] digits = S.toCharArray();
        long num1 = 0;
        for (int i = 0; i < digits.length / 2; i++) {
            if (digits[0] == '0' && i > 0)
                continue; // the number starts with 0 and becomes > 0

            num1 = num1 * 10 + (digits[i] - '0');
            long num2 = 0;
            for (int j = i + 1; j < digits.length - 2; j++) {
                num2 = num2 * 10 + (digits[j] - '0');
                List<Integer> res = isAdditiveSplit(digits, num1, num2, j);
                if (!res.isEmpty())
                    return res;
                if (digits[i + 1] == '0')
                    break; // the number starts with 0 and becomes > 0
            }
        }

        return new LinkedList<>();
    }

    private List<Integer> isAdditiveSplit(char[] digits, long num1, long num2, int end) {
        List<Integer> res = new LinkedList<>();
        if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE)
            return res;

        res.add((int) num1);
        res.add((int) num2);
        while (end < digits.length - 1) {
            char[] target = String.valueOf(num1 + num2).toCharArray();
            for (int i = end + 1; i < end + target.length + 1; i++)
                if (i < digits.length && digits[i] != target[i - end - 1])
                    return new LinkedList<>();

            long tmp = num2;
            num2 = num1 + num2;
            if (num2 > Integer.MAX_VALUE)
                return new LinkedList<>();

            num1 = tmp;
            end = end + target.length;
            res.add((int) num2);
        }
        return res;
    }

    public static void main(String[] args) {
        SplitArrayIntoFibonacciSequence sln = new SplitArrayIntoFibonacciSequence();
        System.out.println(sln.splitIntoFibonacci("123456579"));
        System.out.println(sln.splitIntoFibonacci("1101111"));
        System.out.println(sln.splitIntoFibonacci("214748364721474836422147483641"));
        System.out.println(sln.splitIntoFibonacci("97127987005586830212"));
        System.out.println(
                sln.splitIntoFibonacci("27203104898615677857731269848566027534594592801817"));
    }

}
