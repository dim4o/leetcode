// Given a balanced parentheses string S, 
// compute the score of the string based on the following rule ...
// See: https://leetcode.com/problems/score-of-parentheses/
// TODO: Solve the problem

package leetcode.string;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        return -1;
    }
    
    public static void main(String[] args) {
        ScoreOfParentheses sln = new ScoreOfParentheses();
        System.out.println(sln.scoreOfParentheses("()")); // 1
        System.out.println(sln.scoreOfParentheses("(())")); // 2
        System.out.println(sln.scoreOfParentheses("()()")); // 2
        System.out.println(sln.scoreOfParentheses("(()(()))")); // 6
    }

}
