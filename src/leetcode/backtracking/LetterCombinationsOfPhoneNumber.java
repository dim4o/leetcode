// Given a string containing digits from 2-9 inclusive, 
// return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below. 
// Note that 1 does not map to any letters.
// See: https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        String[] letters = new String[digits.length()];
        char[] res = new char[digits.length()];

        for (int i = 0; i < digits.length(); i++)
            letters[i] = map.get(digits.charAt(i));

        gen(letters, res, 0, ans);

        return ans;
    }

    private void gen(String[] letters, char[] result, int pos, List<String> ans) {
        if (pos == letters.length)
            ans.add(String.valueOf(result));
        else
            for (int i = 0; i < letters[pos].length(); i++) {
                result[pos] = letters[pos].charAt(i);
                gen(letters, result, pos + 1, ans);
            }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("27"));
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("234"));
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("9"));
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations(""));
    }

}
