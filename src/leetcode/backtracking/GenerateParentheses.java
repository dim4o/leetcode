// Given n pairs of parentheses, write a function 
// to generate all combinations of well-formed parentheses.
// See: https://leetcode.com/problems/generate-parentheses/

package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        gen(n, result, new StringBuilder(), 0, 0);
        return result;
    }
    
    public void gen(int n, List<String> result, StringBuilder curr, int open, int close) {
        if (curr.length() == n << 1) {
            result.add(curr.toString());
        }
        
        if (open < n) {
            curr.append('(');
            gen(n, result, curr, open + 1, close);
            curr.setLength(curr.length() - 1);
        }

        if (close < n && open > close) {
            curr.append(')');
            gen(n, result, curr, open, close + 1);
            curr.setLength(curr.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        GenerateParentheses sln = new GenerateParentheses();
        System.out.println(sln.generateParenthesis(3));
    }
}
