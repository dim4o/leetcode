// Given a non-negative integer num represented as a string, remove k digits from the number 
// so that the new number is the smallest possible.
// Note:
//   - The length of num is less than 10002 and will be ≥ k.
//   - The given num does not contain any leading zero.
// See: https://leetcode.com/problems/remove-k-digits/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/

package leetcode.stack;

import java.util.Stack;

public class RemoveKdigits {
    /**
     * Greedy solution. O(n) time, O(n) space.
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        if (k == 0) return num;
        /*
         * The idea to look from left to right i to remove the first peak digit.
         * After the removal the number is smallest possible. Perform this "k" times.
         * The stack is used to find a peak digit.
         */
        Stack<Character> stack = new Stack<>();
        char[] digits = num.toCharArray();
        int pos = 0;
        while (pos < digits.length) {
            // if the slope of the peak is long (1234567890) we have to continue to pop the stack.
            while (k > 0 && !stack.empty() && stack.peek() > digits[pos]) {
                stack.pop();
                k--;
            }
            stack.add(digits[pos++]);
        }

        // If the peak is at the end of the number(123456789) - pop the stack "k" times.
        while (k-- > 0) stack.pop();
        
        // Skip the trailing zeroes from the stack
        int i = 0;
        while (i < stack.size() && stack.get(i) == '0') i++;

        StringBuilder sb = new StringBuilder();
        for (int j = i; j < stack.size(); j++)
            sb.append(stack.get(j));
        
        return sb.length() != 0 ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        RemoveKdigits sln = new RemoveKdigits();
        System.out.println(sln.removeKdigits("1432219", 3));
        System.out.println(sln.removeKdigits("123456789", 3));
        System.out.println(sln.removeKdigits("10200", 1));
        System.out.println(sln.removeKdigits("100", 1));
        System.out.println(sln.removeKdigits("10", 1));
        System.out.println(sln.removeKdigits("21", 1));
        System.out.println(sln.removeKdigits("1234567890", 9));
    }

}
