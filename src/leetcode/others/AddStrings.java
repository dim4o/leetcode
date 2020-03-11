// Given two non-negative integers num1 and num2 represented as string, 
// return the sum of num1 and num2.
// See: https://leetcode.com/problems/add-strings/

package leetcode.others;

public class AddStrings {
   
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1--) - 48 : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2--) - 48 : 0;
            res.append((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
        }

        if (carry > 0)
            res.append(carry);

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        
    }

}
