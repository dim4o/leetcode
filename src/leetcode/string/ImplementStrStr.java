// Implement strStr().
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

package leetcode.string;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;

                if (j == needle.length() - 1)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr sln = new ImplementStrStr();
        System.out.println(sln.strStr("heello", "ll"));
        System.out.println(sln.strStr("mississippi", "issip"));
    }

}
