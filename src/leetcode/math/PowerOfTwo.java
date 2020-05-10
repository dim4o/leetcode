// Given an integer, write a function to determine if it is a power of two.
// See: https://leetcode.com/problems/power-of-two/

package leetcode.math;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int mask = 1;
        while ((mask & n) == 0) mask <<= 1;
        return mask == n;
    }
    
    public static void main(String[] args) {
        PowerOfTwo sln = new PowerOfTwo();
        System.out.println(sln.isPowerOfTwo(-4)); // false
        System.out.println(sln.isPowerOfTwo(0));  // false
        System.out.println(sln.isPowerOfTwo(1));  // true
        System.out.println(sln.isPowerOfTwo(2));  // true
        System.out.println(sln.isPowerOfTwo(3));  // false
        System.out.println(sln.isPowerOfTwo(4));  // true
        System.out.println(sln.isPowerOfTwo(16)); // true
        System.out.println(sln.isPowerOfTwo(255));// false
        System.out.println(sln.isPowerOfTwo(256));// true

    }

}
