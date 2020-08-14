// Given a string which consists of lowercase or uppercase letters, find the length of the longest 
// palindrome that can be built with those letters.
// This is case sensitive, for example "Aa" is not considered a palindrome here.
// Note:
// Assume the length of given string will not exceed 1,010.
// See: https://leetcode.com/problems/longest-palindrome/
// See: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
// See: https://leetcode.com/problems/longest-palindrome/discuss/791001/Java-Fast-and-Concise-solution

package leetcode.array_and_hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrom {
    /**
     * Solution with Map - O(N) time, O(N) space
     */
    public int longestPalindrome(String s) {
        int[] count = new int['z' - 'A' + 1];
        int len = 0;
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'A']++;

        for (int val : count)
            len += (val / 2) * 2;

        return s.length() == len ? len : ++len;
    }

    /**
     * Solution with Map - O(N) time, O(N) space
     */
    public int longestPalindrome1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        boolean odd = false;
        for (int val : map.values()) {
            len += val;
            if (val % 2 != 0) {
                odd = true;
                --len;
            }
        }

        return odd ? ++len : len;
    }

    public static void main(String[] args) {
        LongestPalindrom sln = new LongestPalindrom();
        System.out.println(sln.longestPalindrome("abccccdd"));
        System.out.println(sln.longestPalindrome("bb"));

        // 'A'(65) - 'Z'(90)
        // 'a'(97) - 'z'(122)
        // 'z'(122) - 'A(65) = 57
    }

}
