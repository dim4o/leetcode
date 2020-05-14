// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
// Note: For the purpose of this problem, we define empty string as valid palindrome.
// See: https://leetcode.com/problems/valid-palindrome/
// See: https://leetcode.com/problems/valid-palindrome/discuss/631511/Java-Two-concise-solutions

package leetcode.string;

public class ValidPalindrome {
    /**
     * Solution 2
     * Takes advantage of Character.isLetterOrDigit() method
     */
    public boolean isPalindrome(String s) {
        char[] sentence = s.toLowerCase().toCharArray();
        int l = -1, r = sentence.length;

        while (++l < --r) {
            while (l < r && !Character.isLetterOrDigit(sentence[l])) {l++;}
            while (l < r && !Character.isLetterOrDigit(sentence[r])) {r--;}
            if (sentence[l] != sentence[r]) return false;
        }

        return true;
    }
    /**
     * Solution 1
     * Note: Pay attention when you see a word "alphanumeric" = a-z + 0-9 !
     * O(n) time, O(n) space(can be done with O(1) without the char[] array).
     */
    public boolean isPalindrome_var1(String s) {
        char[] sentence = s.toLowerCase().toCharArray();
        int l = -1, r = sentence.length;

        while (++l < --r) {
            while (l < r && sentence[l] < '0' || sentence[l] > 'z'
                    || (sentence[l] > '9' && sentence[l] < 'a'))
                l++;
            
            while (l < r && sentence[r] < '0' || sentence[r] > 'z'
                    || (sentence[r] > '9' && sentence[r] < 'a'))
                r--;

            if (sentence[l] != sentence[r]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sln = new ValidPalindrome();
        System.out.println(sln.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sln.isPalindrome("race a car"));
        System.out.println(sln.isPalindrome("0p"));
        System.out.println(sln.isPalindrome("01p"));
        System.out.println(sln.isPalindrome("Pp"));

    }

}
