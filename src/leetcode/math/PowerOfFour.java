// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
// Follow up: Could you solve it without loops/recursion?
// See: https://leetcode.com/problems/power-of-four/

package leetcode.math;

public class PowerOfFour {
    /**
     * Solution 3 - without loops/recursion solution.
     */
    public boolean isPowerOfFour(int n) {
        /*
         * For example:
         *   64 = 1000000(2)
         *   63 =  111111(2)
         */
        boolean isPowerOf2 = (n & (n-1) ) == 0;
        /*
         * If "n" is power of 2 -> n = 1000...000
         * x55555555 = 1431655765 = 1010101...101(2)
         * => if n & x55555555 == 0 the count of bits is even
         *    else the count of bits is odd
         */
        boolean isOddCountOfBits = (n & 0x55555555) != 0;
        return n > 0 && isPowerOf2 && isOddCountOfBits;
    }
    
    /**
     * Solution 2 - without loops/recursion solution.
     */
    public boolean isPowerOfFour_var2(int n) {
        int countOfBits = (int)(Math.log(n) /  Math.log(2) + 1);
        int bigPow = 1073741824; // 2^30 - a big power of 2 that not overflow the int.
        return n > 0 && bigPow % n == 0 && countOfBits % 2 == 1;
    }
    
    
    /**
     * Solution 1 - Simple while loop solution.
     */
    public boolean isPowerOfFour_var1(int n) {
        while (n > 0 && n % 4 == 0) {
           n = n / 4;
        }
        return n == 1;
    }
    
    public static void main(String[] args) {
        PowerOfFour sln = new PowerOfFour();
        System.out.println(sln.isPowerOfFour(64));
        
        System.out.println(0x55555555);
    }

}
