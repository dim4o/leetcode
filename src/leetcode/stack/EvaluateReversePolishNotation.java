// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
// See: https://leetcode.com/problems/evaluate-reverse-polish-notation/

package leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int secondOperand = s.pop();
                int firstOperand = s.pop();
                
                switch (token) {
                case "+":
                    s.push(firstOperand + secondOperand);
                    break;
                case "-":
                    s.push(firstOperand - secondOperand);
                    break;
                case "*":
                    s.push(firstOperand * secondOperand);
                    break;
                case "/":
                    s.push(firstOperand / secondOperand);
                }
            } else {
                s.push(Integer.parseInt(token));
            }
        }

        return s.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation sln = new EvaluateReversePolishNotation();

        String[] tokens1 = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(sln.evalRPN(tokens1)); // 22

        String[] tokens2 = new String[] { "4", "13", "5", "/", "+" };
        System.out.println(sln.evalRPN(tokens2)); // 6

        String[] tokens3 = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(sln.evalRPN(tokens3)); // 9
    }

}
