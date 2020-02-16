// See: https://leetcode.com/problems/remove-outermost-parentheses/

package leetcode.stack;

import java.util.Stack;

public class RemoveOutermostParentheses {

    // TODO: The performance can be enhanced
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder decomp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            char currChar = S.charAt(i);

            if (currChar == '(') {
                stack.push('(');
                decomp.append('(');
            } else if (!stack.empty()) {
                stack.pop();
                decomp.append(')');
            }

            if (stack.empty()) {
                result.append(decomp.subSequence(1, decomp.length() - 1));
                decomp.setLength(0);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses sln = new RemoveOutermostParentheses();
        String input1 = "(()())(())(()(()))";
        String output1 = "()()()()(())";

        System.out.println(sln.removeOuterParentheses(input1).equals(output1));
    }

}
