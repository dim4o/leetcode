// Write a function that takes an unsigned integer and return the number of '1' bits it has 
// (also known as the Hamming weight).
// See: https://leetcode.com/problems/number-of-1-bits/

package leetcode.others;

public class NumberOf1Bits {
    
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                count++;
            n >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits sln = new NumberOf1Bits();
        System.out.println(sln.hammingWeight(11));
        System.out.println(sln.hammingWeight(128));
        System.out.println(sln.hammingWeight(-3));
    }

}
