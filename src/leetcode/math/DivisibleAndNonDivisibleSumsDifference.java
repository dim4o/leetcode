// You are given positive integers n and m.
// Define two integers, num1 and num2, as follows:
// num1: The sum of all integers in the range [1, n] that are not divisible by m.
// num2: The sum of all integers in the range [1, n] that are divisible by m.
// Return the integer num1 - num2.
// See: https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/

package leetcode.math;

import java.util.stream.IntStream;

public class DivisibleAndNonDivisibleSumsDifference {

    /**
     * Brute force, not optimal, but concise solution
     */
    public int differenceOfSums1(int n, int m) {
        return IntStream.range(1, n + 1).filter(i -> i % m != 0).reduce(Integer::sum).orElse(0)
                - IntStream.range(1, n + 1).filter(i -> i % m == 0).reduce(Integer::sum).orElse(0);
    }

    /**
     * Fast solution, programmatically optimal but maybe can be enhanced with a math trick?
     */
    public int differenceOfSums2(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i % m != 0)
                num1 += i;
            else num2 += i;
        }
        return num1 - num2;
    }

    /**
     * I found a math solution with arithmetic progression sum trick
     */
    public int differenceOfSums3(int n, int m) {
        int sum1 = (n * (1 + n)) / 2;
        int M = n / m;
        int sum2 = 2 * m * ((M * (1 + M)) / 2);
        return sum1 - sum2;
    }

    public static void main(String[] args) {
        DivisibleAndNonDivisibleSumsDifference sln = new DivisibleAndNonDivisibleSumsDifference();

        System.out.println(sln.differenceOfSums3(10, 3)); // 19
        System.out.println(sln.differenceOfSums3(5, 6)); // 15
        System.out.println(sln.differenceOfSums3(5, 1)); // -15
    }
}
