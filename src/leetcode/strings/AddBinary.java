// Given two binary strings, return their sum (also a binary string).
// The input strings are both non-empty and contains only characters 1 or 0.
// See: https://leetcode.com/problems/add-binary/
// See: https://leetcode.com/problems/add-binary/discuss/536481/Two-Java-Solutions

package leetcode.strings;

public class AddBinary {
    public String addBinary(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1--) - 48 : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2--) - 48 : 0;
            res.append((n1 + n2  + carry) % 2);
            carry = (n1 + n2  + carry) / 2;
        }
        
        if (carry > 0) res.append(carry);

        return res.reverse().toString();
    }
    
    // // Working solution / good performance
    public String addBinary2(String a, String b) {
        StringBuilder res = new StringBuilder();
        int l1 = a.length() - 1, l2 = b.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int a1 = l1 >= 0 ? a.charAt(l1--) - 48 : 0;
            int b1 = l2 >= 0 ? b.charAt(l2--) - 48 : 0;
            if ((a1 ^ b1) == 1) {
                res.append(carry ^ 1);
                carry &= 1;
            } else {
                res.append(carry);
                carry = a1 & b1;
            }
        }
        if (carry == 1) res.append(carry);

        return res.reverse().toString();
    }
    
    // Not working solution because the "long" type is not enough
    public String addBinary1(String a, String b) {
        long n1 = 0, n2 = 0;
        int l1 = 0, l2 = 0;

        while (l1 < a.length() || l2 < b.length()) {
            if (l1 < a.length())
                n1 = 2 * n1 + (a.charAt(l1++) - 48);

            if (l2 < b.length())
                n2 = 2 * n2 + (b.charAt(l2++) - 48);
        }
        long sum = n1 + n2;
        if (sum == 0)
            return "0";
        String res = "";
        while (sum > 0) {
            res = sum % 2 + res;
            sum /= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        AddBinary sln = new AddBinary();
        System.out.println(sln.addBinary("1011", "10111"));
        System.out.println(sln.addBinary("1010", "1011"));
        System.out.println(sln.addBinary("1", "11"));
        System.out.println(sln.addBinary("0", "0"));
        System.out.println(sln.addBinary("0", "1"));
    }

}
