// Given a positive integer, output its complement number. The complement strategy is to flip the bits 
// of its binary representation.
// See: https://leetcode.com/problems/number-complement/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
// See: https://leetcode.com/problems/number-complement/discuss/612426/Java-1-Liner-Solution

package leetcode.others;

public class NumberComplement {
    public int findComplement(int num) {
        /* 
         * The number of the bits in the binary representation:
         * int count = (int)(Math.log(num) /  Math.log(2) + 1); 
         */
        return num != 0 ? ((~0) << (int)(Math.log(num) /  Math.log(2) + 1)) ^ ~num : 1;
    }
    
    public static void main(String[] args) {
        NumberComplement sln = new NumberComplement();
        System.out.println(sln.findComplement(0));
    }

}
