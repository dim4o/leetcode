// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.
// See: https://leetcode.com/problems/valid-parentheses/

package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!map.containsKey(curr)) {
                stack.push(curr);
            } else if (stack.empty() || map.get(curr) != stack.pop()) {
                    return false;
            }
        }

        return stack.empty();   
    }

    public static void main(String... args) {
        ValidParentheses sln = new ValidParentheses();
        System.out.println(sln.isValid("()"));
        System.out.println(sln.isValid("()[]{}"));
        System.out.println(sln.isValid("([)]"));
        System.out.println(sln.isValid("]"));
    }
}
