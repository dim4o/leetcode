// Given a word, you need to judge whether the usage of capitals in it is right or not.
// We define the usage of capitals in a word to be right when one of the following cases holds:
//   1. All letters in this word are capitals, like "USA".
//   2. All letters in this word are not capitals, like "leetcode".
//   3. Only the first letter in this word is capital, like "Google".
// Otherwise, we define that this word doesn't use capitals in a right way.
// See: https://leetcode.com/problems/detect-capital/submissions/
// See: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/

package leetcode.string;

public class DetectCapital {

    // TODO: Try the easier solution with a regex.

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;

        boolean upper0 = Character.isUpperCase(word.charAt(0));
        boolean upper1 = Character.isUpperCase(word.charAt(1));

        for (int i = 1; i < word.length() - 1; i++) {
            if (Character.isUpperCase(word.charAt(i)) && Character.isLowerCase(word.charAt(i + 1))
                    || Character.isLowerCase(word.charAt(i))
                            && Character.isUpperCase(word.charAt(i + 1)))
                return false;
        }

        return upper0 && upper1 || upper0 && !upper1 || !upper0 && !upper1;
    }

    public static void main(String[] args) {
        DetectCapital sln = new DetectCapital();
        System.out.println(sln.detectCapitalUse("USA")); // true
        System.out.println(sln.detectCapitalUse("FlaG")); // false
        System.out.println(sln.detectCapitalUse("aAAA")); // false
        System.out.println(sln.detectCapitalUse("Google")); // false
        System.out.println(sln.detectCapitalUse("ggg")); // false
    }

}
