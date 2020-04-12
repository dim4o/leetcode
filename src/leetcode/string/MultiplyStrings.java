// Given two non-negative integers num1 and num2 represented as strings, 
// return the product of num1 and num2, also represented as a string.
// See: https://leetcode.com/problems/multiply-strings/

package leetcode.string;

public class MultiplyStrings {
    private StringBuilder res = new StringBuilder();
    
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        
        String tail = "";
        String ans = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            res.setLength(0);
            int n1 = num1.charAt(i) - 48;
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - 48;
                res.append((n1 * n2 + carry) % 10);
                carry = (n1 * n2 + carry) / 10;
            }
            if (carry > 0)
                res.append(carry);
            
            String curr = res.reverse().toString() + tail;
            tail += "0";
            
            ans = add(ans, curr);
        }

        return ans;
    }

    private String add(String num1, String num2) {
        res.setLength(0);
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
        MultiplyStrings sln = new MultiplyStrings();
        System.out.println(sln.multiply("0", "0")); // 6
        System.out.println(sln.multiply("0", "10")); // 6
        System.out.println(sln.multiply("2", "3")); // 6
        System.out.println(sln.multiply("123", "456")); // 56088
    }

}
