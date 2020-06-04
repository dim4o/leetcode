// Given an input string, reverse the string word by word.
// See: https://leetcode.com/problems/reverse-words-in-a-string/

package leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {
    /**
     * Solution 2. StringBuilder will increase the performance but it is not a
     * challenge.
     */
    public String reverseWords(String s) {
        String ans = "";
        String currWord = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch != ' ') {
                currWord += ch;
            } else if (!currWord.isEmpty()) {
                ans = currWord + " " + ans;
                currWord = "";
            }
        }

        ans = currWord + " " + ans;

        return ans.trim();
    }

    /**
     * Solution 1: Easy solution with Java Arrays/Collections API
     */
    public String reverseWords_var1(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        System.out.println(list);
        Collections.reverse(list);

        return String.join(" ", list.toArray(new String[list.size()]));
    }

    public static void main(String[] args) {
        ReverseWordsInString sln = new ReverseWordsInString();
        System.out.println(sln.reverseWords("the sky is   blue"));
        System.out.println(sln.reverseWords(" hello  world"));;
    }

}
