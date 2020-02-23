// Given a string S, we can transform every letter individually to be 
// lowercase or uppercase to create another string.
// Return a list of all possible strings we could create.
// See: https://leetcode.com/problems/letter-case-permutation/

package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new LinkedList<String>();
        helper(S.toCharArray(), 0, result);
        return result;
    }

    private void helper(char[] ch, int pos, List<String> result) {
        if (pos == ch.length) {
            result.add(String.valueOf(ch));
            return;
        }

        if (ch[pos] > '9' || ch[pos] < '0') {
            ch[pos] = Character.toUpperCase(ch[pos]);
            helper(ch, pos + 1, result);
            ch[pos] = Character.toLowerCase(ch[pos]);
        }

        helper(ch, pos + 1, result);
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b1"));
        System.out.println(new LetterCasePermutation().letterCasePermutation("3z4"));
        System.out.println(new LetterCasePermutation().letterCasePermutation("12345"));
        System.out.println(new LetterCasePermutation().letterCasePermutation(""));

    }
}
