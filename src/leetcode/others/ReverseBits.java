// Reverse bits of a given 32 bits unsigned integer.
// See: https://leetcode.com/problems/reverse-bits/

package leetcode.others;

public class ReverseBits {

    // Solution 3 - Bit manipulation + direct conversion
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = 2 * res + (n & 1);
            n >>= 1;
        }

        return res;
    }
    /**
     * Solution 2 - String + conversion
     */
    public int reverseBits_var2(int n) {
        String num = "";
        for (int i = 0; i < 32; i++) {
            num = num + (n & 1);
            n >>= 1;
        }
        
        int res = 0;
        for (char ch : num.toCharArray())
            res = 2 * res + ch - '0';

        return res;
    }
    
    /**
     * Solution 1 - Using Java API
     */
    public int reverseBits_var1(int n) {
        return Integer.reverse(n);
    }
    
    public static void main(String[] args) {
        ReverseBits sln = new ReverseBits();
        System.out.println(sln.reverseBits(-3));
    }

}
