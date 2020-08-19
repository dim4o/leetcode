// A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
// We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
// The rules of Goat Latin are as follows:
//   - If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
//     For example, the word 'apple' becomes 'applema'.
// 
//   - If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
//     For example, the word "goat" becomes "oatgma".
// 
//   - Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
//     For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
// Return the final sentence representing the conversion from S to Goat Latin. 
// See: https://leetcode.com/problems/goat-latin/
// See: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/

package leetcode.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoatLatin {
    /**
     * Using a StringBuilder will increase the performance but will decrease the
     * readability, so here I prefer to keep the code simple instead to use an ugly
     * StringBuilder.
     */
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String ma = "maa";
        Set<Character> vowel = new HashSet<>(
                List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < words.length; i++) {
            if (!vowel.contains(words[i].charAt(0)))
                words[i] = words[i].substring(1) + words[i].charAt(0);

            words[i] += ma;
            ma += "a";
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        GoatLatin sln = new GoatLatin();
        System.out.println(sln.toGoatLatin("I speak Goat Latin"));
        System.out.println(sln.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

}
