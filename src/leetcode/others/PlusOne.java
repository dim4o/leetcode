package leetcode.others;

import java.util.Arrays;

// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
// See: https://leetcode.com/problems/plus-one/
// TODO: Update with more simple and clear solution

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        int reminder = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            
            int curr_val = digits[i] + reminder;
            if (curr_val == 10) {
                reminder = 1;
                digits[i] = 0;
            } else {
                digits[i] = curr_val;
                reminder = 0;
            }
        }
        if (reminder == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String... args) {
        PlusOne sln = new PlusOne();
        System.out.println(Arrays.toString(sln.plusOne(new int[] {1, 2, 3})));
        System.out.println(Arrays.toString(sln.plusOne(new int[] {1, 2, 8})));
        System.out.println(Arrays.toString(sln.plusOne(new int[] {1, 2, 9})));
        System.out.println(Arrays.toString(sln.plusOne(new int[] {1, 9, 9})));
        System.out.println(Arrays.toString(sln.plusOne(new int[] {9, 9, 9})));

    }
}
