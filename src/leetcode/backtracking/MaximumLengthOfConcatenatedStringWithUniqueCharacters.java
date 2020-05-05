// Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
// Return the maximum possible length of s.
// See: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    int max = 0;
    
    public int maxLength(List<String> arr) {
        gen(arr, new LinkedList<>(), 0, 0);
        return max;
    }

    private void gen(List<String> arr, LinkedList<String> curr, int start, int len) {
        if (arr.size() == start)
            return;

        for (int i = start; i < arr.size(); i++) {
            curr.add(arr.get(i));
            if (isUnique(curr)) {
                gen(arr, curr, i + 1, len + arr.get(i).length());
                max = Math.max(max, len + arr.get(i).length());
            }
            curr.removeLast();
        }
    }
    
    private boolean isUnique(List<String> arr) {
        int[] alphabet = new int[26];
        for (String str : arr)
            for (int ch : str.toCharArray())
                if (++alphabet[ch - 'a'] > 1) return false;
        return true;
    }

    public static void main(String[] args) {
        MaximumLengthOfConcatenatedStringWithUniqueCharacters sln = new MaximumLengthOfConcatenatedStringWithUniqueCharacters();
        List<String> arr = Arrays.asList(new String[] { "un", "iq", "ue" });

        System.out.println(sln.maxLength(arr));
    }

}
