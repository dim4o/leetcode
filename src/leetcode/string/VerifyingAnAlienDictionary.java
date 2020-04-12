// In an alien language, surprisingly they also use English lowercase letters, 
// but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
// Given a sequence of words written in the alien language, and the order of the alphabet, 
// return true if and only if the given words are sorted lexicographicaly in this alien language.
// See: https://leetcode.com/problems/verifying-an-alien-dictionary/
    
package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {
    /**
     * Array solution.
     * Note that even small and simple dictionary the array implementation is much faster than the HashMap.
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] mapper = new int[26];
        for (int i = 0; i < order.length(); i++)
            mapper[order.charAt(i) - 'a'] = i;

        boolean res = false;
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                if (mapper[w1.charAt(j) - 'a'] < mapper[w2.charAt(j) - 'a']) {
                    res = true;
                    break;
                }
                else if (mapper[w1.charAt(j) - 'a'] > mapper[w2.charAt(j) - 'a'])
                    return false;
            }

            if (!res && w1.length() > w2.length()) {
                return false;
            }
        }
        
        return res;
    }

    /**
     * HashMap implementation.
     */
    public boolean isAlienSorted_var1(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);

        boolean res = false;
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                if (map.get(w1.charAt(j)) < map.get(w2.charAt(j))) {
                    res = true;
                    break;
                }
                else if (map.get(w1.charAt(j)) > map.get(w2.charAt(j)))
                    return false;
            }

            if (!res && w1.length() > w2.length()) {
                return false;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary sln = new VerifyingAnAlienDictionary();
        System.out.println(sln.isAlienSorted(new String[] { "hello", "leetcode" },
                "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(sln.isAlienSorted(new String[] { "word", "world", "row" },
                "worldabcefghijkmnpqstuvxyz"));
        System.out.println(sln.isAlienSorted(new String[] { "kuvp", "q" },
                "ngxlkthsjuoqcpavbfdermiywz"));
    }

}
