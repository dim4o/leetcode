// Determine whether an integer is a palindrome. 
// An integer is a palindrome when it reads the same backward as forward.
// See: https://leetcode.com/problems/palindrome-number/

package com.leetcode.math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x != 0)) {
            return false;
        }
        int original = x;
        int reversed = 0;
        while (x != 0) {
            reversed = x % 10 + reversed * 10; // x = 12321 -> 1 -> 10 -> 10 + 2 = 21, ...
            x /= 10;
        }
        return reversed == original;
    }
    
    public boolean isPalindrome_slow(int x) {
        if (x < 0) {
            return false;
        }
        char[] arrNum = ("" + x).toCharArray();
        int len = arrNum.length;
        for (int i = 0; i < len/2; i++) {
            if (arrNum[i] != arrNum[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String... args) {
        PalindromeNumber sln = new PalindromeNumber();
        System.out.println(sln.isPalindrome(-121));
        System.out.println(sln.isPalindrome(12321));
        System.out.println(sln.isPalindrome(1232));
        System.out.println(sln.isPalindrome(1232));
        System.out.println(sln.isPalindrome(1));
    }
}
