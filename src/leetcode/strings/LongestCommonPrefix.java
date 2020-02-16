// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string ""
// See: https://leetcode.com/problems/longest-common-prefix/

package leetcode.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder lcp = new StringBuilder("");
        if (strs.length == 0) {
            return lcp.toString();
        }
       
        for (int i = 0; ;i++) {
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return lcp.toString();
                }
            };
            lcp.append(strs[0].charAt(i));
        }
    }
    
    public static void main(String... args) {
        LongestCommonPrefix sln = new LongestCommonPrefix();
        System.out.println(sln.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(sln.longestCommonPrefix(new String[] {"ab","bc","de"}));
        System.out.println(sln.longestCommonPrefix(new String[] {"ab"}));
        System.out.println(sln.longestCommonPrefix(new String[] {""}));
        System.out.println(sln.longestCommonPrefix(new String[] {"ab", "abc"}));
        System.out.println(sln.longestCommonPrefix(new String[] {}));
    }
}
