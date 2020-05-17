// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
// The order of output does not matter.
// See: https://leetcode.com/problems/find-all-anagrams-in-a-string/
// See: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/

package leetcode.array_and_hashtable;

import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInString {

    /**
     * O(n) time solution.
     * TODO: Try to find another solution
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (p.length() > s.length())
            return res;
        int[] count = new int[26];
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();

        for (int i = 0; i < P.length; i++) {
            count[S[i] - 'a']++;
            count[P[i] - 'a']--;
        }

        for (int i = p.length(); i < S.length; i++) {
            if (allZeroes(count))
                res.add(i - p.length());

            count[S[i] - 'a']++;
            count[S[i - p.length()] - 'a']--;
        }

        if (allZeroes(count))
            res.add(S.length - p.length());

        return res;
    }

    private boolean allZeroes(int[] count) {
        for (int i : count)
            if (i != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
