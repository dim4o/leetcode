// Implement int sqrt(int x)
// See: https://leetcode.com/problems/sqrtx/

package com.leetcode;


public class Sqrt {
    /**
     * Use the Newton's  method for finding root
     * x^2 - a = 0, f(x) = x^2 - a
     * x_(n+1) = x_n - f(x_n)/f'(x_n)
     * In our case: x_(n+1) = x_n - (x_n^2 - a)/2*x_n
     * x_(n+1) = (x_n^2 + a) / 2*x_n
     */
    public int mySqrt(int x) {
        double curr = 1;
        while (true) {
            curr = (curr * curr + x) / (2 * curr);
            if ((long) (curr * curr) <= x)
                break;
        }
        return (int) curr;
    }

    public int mySqrt_slow(int x) {
        long sqrt = 1;
        while (sqrt * sqrt <= x / 2) {
            sqrt++;
        }
        return (int) sqrt - 1;
    }

    public static void main(String... args) {

        Sqrt sln = new Sqrt();
        System.out.println(sln.mySqrt(0)); // 3
        System.out.println(sln.mySqrt(4)); // 2
        System.out.println(sln.mySqrt(8)); // 2
        System.out.println(sln.mySqrt(9)); // 3
        System.out.println(sln.mySqrt(16)); // 3
        System.out.println(sln.mySqrt(17)); // 3
        System.out.println(sln.mySqrt(2147395600)); // 3
    }

}
