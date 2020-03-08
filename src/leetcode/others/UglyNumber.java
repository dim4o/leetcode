// Write a program to check whether a given number is an ugly number.
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
// See: https://leetcode.com/problems/ugly-number/

package leetcode.others;

public class UglyNumber {

    public boolean isUgly(int num) {
        if (num == 0)  return false;
        int[] factors = new int[] {2, 3, 5};
        for (int factor : factors)
            while (num % factor == 0)
                num /= factor;
        return num == 1;
    }
    
    public static void main(String[] args) {
        UglyNumber sln = new UglyNumber();
        System.out.println(sln.isUgly(6));
        System.out.println(sln.isUgly(8));
        System.out.println(sln.isUgly(14));
    }

}
