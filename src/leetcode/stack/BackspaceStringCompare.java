// Given two strings S and T, return if they are equal when both are typed into empty text editors. 
// # means a backspace character.
// See: https://leetcode.com/problems/backspace-string-compare/

package leetcode.stack;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return reduce(S).equals(reduce(T));
    }

    private Stack<Character> reduce(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != '#')
                stack.add(s.charAt(i));
            else if (!stack.empty())
                stack.pop();

        return stack;
    }

    public static void main(String[] args) {
        BackspaceStringCompare sln = new BackspaceStringCompare();
        System.out.println(sln.backspaceCompare("ab#c", "ad#c"));
        System.out.println(sln.backspaceCompare("ab##", "c#d#"));
        System.out.println(sln.backspaceCompare("ab##", "a#c"));

        System.out.println(sln.backspaceCompare("##c", "#c"));
    }

}
