// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
// See: https://leetcode.com/problems/add-digits/
// See: https://leetcode.com/problems/add-digits/discuss/640604/Java-Two-solutions

package leetcode.math;

public class AddDigits {
    /**
     * Constant time/space solution with math trick.
     */
    public int addDigits(int num) {
        if (num > 9 && num % 9 == 0) return 9;
        return num >= 10 ? num % 9 : num;
    }
    
    /**
     * Solution 1: Easy recursion + while loop
     */
    public int addDigits_var1(int num) {
        while (num >= 10) num = add(num);
        return num;
    }
    
    private int add(int num) {
        return num < 10 ? num : num % 10 + add(num / 10);
    }

}
