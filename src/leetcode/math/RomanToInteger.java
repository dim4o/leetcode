// Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
// See: https://leetcode.com/problems/roman-to-integer/

package leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
     * Solution 2: HashMap solution - cleaner but not faster.
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int prev = 0;
        
        int res = 0;
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            res += map.get(ch);
            if (prev < map.get(ch))
                res -= 2 * prev;
            
            prev = map.get(ch);
        }

        return res;
    }

    /**
     * Solution 1: Initial solution
     */
    public int romanToInt_var1(String s) {
        char prev = '\0';
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
            case 'M':
                res += 1000;
                if (prev == 'C')
                    res -= 200;
                break;
            case 'D':
                res += 500;
                if (prev == 'C')
                    res -= 200;
                break;
            case 'C':
                res += 100;
                if (prev == 'X')
                    res -= 20;
                break;
            case 'L':
                res += 50;
                if (prev == 'X')
                    res -= 20;
                break;
            case 'X':
                res += 10;
                if (prev == 'I')
                    res -= 2;
                break;
            case 'V':
                res += 5;
                if (prev == 'I')
                    res -= 2;
                break;
            case 'I':
                res += 1;
                break;
            default:
                break;
            }

            prev = arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        RomanToInteger sln = new RomanToInteger();
        System.out.println(sln.romanToInt("III"));
        System.out.println(sln.romanToInt("IV"));
        System.out.println(sln.romanToInt("IX"));
        System.out.println(sln.romanToInt("LVIII"));
        System.out.println(sln.romanToInt("MCMXCIV"));
    }

}
