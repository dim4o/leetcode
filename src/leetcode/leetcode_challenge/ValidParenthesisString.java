// Given a string containing only three types of characters: '(', ')' and '*', 
// write a function to check whether this string is valid. 
// We define the validity of a string by these rules:
// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
// An empty string is also valid.
// See: https://leetcode.com/problems/valid-parenthesis-string/
// See: https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3301/

package leetcode.leetcode_challenge;

public class ValidParenthesisString {
    // Recursive solution.
    // TODO: Add recursion with memorization, dynamic programming or greedy solution.
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int i, int score) {
        if (i == s.length() || score < 0)
            return score == 0;

        if (s.charAt(i) == '*')
            return helper(s, i + 1, score - 1) || helper(s, i + 1, score + 1)
                    || helper(s, i + 1, score);
        else
            return helper(s, i + 1, s.charAt(i) == '(' ? ++score : --score);
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString().checkValidString("()"));
        System.out.println(new ValidParenthesisString().checkValidString("(*)"));
        System.out.println(new ValidParenthesisString().checkValidString("(*))"));
        System.out.println(new ValidParenthesisString().checkValidString("((((*"));

        System.out.println(new ValidParenthesisString().checkValidString("(*(((*))"));
    }

}
