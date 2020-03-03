// Given an integer, return its base 7 string representation.
// See: https://leetcode.com/problems/base-7/

package leetcode.others;

public class Base7 {
    public String convertToBase7(int num) {
        String sign = num >= 0 ? "" : "-";
        StringBuilder res =new StringBuilder();
        num = num > 0 ? num : -num;
        do {
            res.insert(0, num%7);
            num /= 7;
        } while (num != 0);
        return res.insert(0, sign).toString();
    }

    public static void main(String[] args) {
        Base7 sln = new Base7();
        System.out.println(sln.convertToBase7(100));
        System.out.println(sln.convertToBase7(-7));
        System.out.println(sln.convertToBase7(8));
        System.out.println(sln.convertToBase7(0));
    }

}
