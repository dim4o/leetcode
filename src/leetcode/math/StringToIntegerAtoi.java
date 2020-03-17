// Implement atoi which converts a string to an integer.
// See: https://leetcode.com/problems/string-to-integer-atoi/

package leetcode.math;

public class StringToIntegerAtoi {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int sign = str.charAt(0) == '-' ? -1 : 1;
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(0) == '-' || str.charAt(0) == '+'))
                continue;
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res = res * 10 + str.charAt(i) - 48;
                if (res > Integer.MAX_VALUE && sign > 0)
                    return Integer.MAX_VALUE;
                else if (res > Integer.MAX_VALUE && sign < 0)
                    return Integer.MIN_VALUE;
            } else
                break;

        }
        return (int) res * sign;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi sln = new StringToIntegerAtoi();
        System.out.println(sln.myAtoi("42"));
        System.out.println(sln.myAtoi("   -42"));
        System.out.println(sln.myAtoi("   -42"));
        System.out.println(sln.myAtoi("4193 with words"));
        System.out.println(sln.myAtoi("words and 987"));
        System.out.println(sln.myAtoi("-91283472332"));
        System.out.println(sln.myAtoi("91283472332"));
        System.out.println(sln.myAtoi("   +0 123"));
    }

}
