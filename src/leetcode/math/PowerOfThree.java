// Given an integer, write a function to determine if it is a power of three.
// Follow up: Could you solve it without loops/recursion?
// See: https://leetcode.com/problems/power-of-three/
package leetcode.math;

public class PowerOfThree {
    /**
     * Solution 2 - Constant time solution with math trick.
     */
    public boolean isPowerOfThree(int n) {
        int bigPow = 1162261467; // 3^19 - a big power of 3 that not overflow the int.
        return n > 0 && bigPow % n == 0;
    }
    
    /**
     * Solution 1 - Simple while loop solution.
     */
    public boolean isPowerOfThree_var1(int n) {
        while (n > 0 && n % 3 == 0) {
           n = n / 3;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        PowerOfThree sln = new PowerOfThree();
        System.out.println(sln.isPowerOfThree(0));
        System.out.println(sln.isPowerOfThree(1));
        System.out.println(sln.isPowerOfThree(3));
        System.out.println(sln.isPowerOfThree(4));
        System.out.println(sln.isPowerOfThree(27));
        System.out.println(sln.isPowerOfThree(28));
    }

}
