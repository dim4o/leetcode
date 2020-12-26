// Given two positive integers n and k.
// A factor of an integer n is defined as an integer i where n % i == 0.
// Consider a list of all factors of n sorted in ascending order,
// return the kth factor in this list or return -1 if n has less than k factors.
// See: https://leetcode.com/problems/the-kth-factor-of-n/

package leetcode.math;

public class TheKthFactorOfN {

    public int kthFactor(int n, int k) {
        int currK = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) currK++;
            if (currK == k) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        TheKthFactorOfN sln = new TheKthFactorOfN();

        System.out.println(sln.kthFactor(7, 2)); // 7
        System.out.println(sln.kthFactor(4, 4)); // -1
        System.out.println(sln.kthFactor(1, 1)); // 1
        System.out.println(sln.kthFactor(1000, 16)); // 4
    }
}
