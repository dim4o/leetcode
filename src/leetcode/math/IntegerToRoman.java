// Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
// See: https://leetcode.com/problems/integer-to-roman/

package leetcode.math;

public class IntegerToRoman {

    public String intToRoman(int num) {
        String[] roman = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            int div = num / ints[i];
            num -= div * ints[i]; 
            
            for (int j = 0; j < div; j++) 
                res.append(roman[i]);
        }
        
        return res.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman sln = new IntegerToRoman();
        System.out.println(sln.intToRoman(1994));
        System.out.println(sln.intToRoman(58));
        System.out.println(sln.intToRoman(9));
        System.out.println(sln.intToRoman(4));
        System.out.println(sln.intToRoman(1));
        System.out.println(sln.intToRoman(2));
        System.out.println(sln.intToRoman(3));
        System.out.println(sln.intToRoman(19));
    }

}
