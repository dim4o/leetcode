// Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
// See: https://leetcode.com/problems/bitwise-and-of-numbers-range/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3308/

package leetcode.leetcode_challenge;

public class BitwiseAndOfNumbersRange {
    
    // Effective solution
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || (m & n) == 0) 
            return 0;
        while (m < n)
            n = n & (n - 1);
        return n;
    }
    
    // Initial naive O(n) solution
    public int rangeBitwiseAnd_var1(int m, int n) {
        if (m == 0 || (m & n) == 0) 
            return 0;
        if (n == m) 
            return n;
        int res = m;
        for (long i = m + 1; i <= n; i++) {
            res = res & (int)i;
            if (res == 0)
                return 0;   
        }
        return res;
    }
    
    public static void main(String[] args) {
        BitwiseAndOfNumbersRange sln = new BitwiseAndOfNumbersRange();
        System.out.println(sln.rangeBitwiseAnd(100, 127));
        System.out.println(100 & 127);
        // System.out.println(2147483646 & 2147483647);
    }

}
