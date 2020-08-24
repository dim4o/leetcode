// Design a data structure that supports the following two operations:
//   - void addWord(word)
//   - boolean search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .
// A . means it can represent any one letter.
// See: https://leetcode.com/problems/design-add-and-search-words-data-structure/
// See: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/

package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class DesignAndSearchWordDataStructure {

    class WordDictionary {
        final class Node {
            final Map<Character, Node> map = new HashMap<>();
            boolean isEnd = false;
        }

        final Node root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            // Iterative implementation
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                curr.map.computeIfAbsent(ch, k -> new Node());
                curr = curr.map.get(ch);
                if (i == word.length() - 1)
                    curr.isEnd = true;
            }
            
            // addWord(word, 0, this.root);
        }
        
        /**  Adds a word recursively to the data structure. */
        public void addWord(String word, int i, Node curr) {
            if (i == word.length()) {
                curr.isEnd = true;
                return;
            }
            char ch = word.charAt(i);
            curr.map.computeIfAbsent(ch, k -> new Node());
            addWord(word, i + 1, curr.map.get(ch));
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        /**
         * Recursive search implementation.
         * @return whether the dictionary contains a specific word.
         */
        private boolean search(String word, int i, Node curr) {
            if (i == word.length())
                return curr.isEnd;
            
            char ch = word.charAt(i);
            if (ch == '.') {
                for (char mapChar : curr.map.keySet()) {
                    if (search(word, i + 1, curr.map.get(mapChar)))
                        return true;
                }
                return false;
            } else if (!curr.map.containsKey(ch))
                return false;
            
            return search(word, i + 1, curr.map.get(ch));
        }

    }

    public static void main(String[] args) {
        WordDictionary wd = new DesignAndSearchWordDataStructure().new WordDictionary();
        wd.addWord("app");
        wd.addWord("apple");
        wd.addWord("alpines");
        wd.addWord("alpi");
        wd.addWord("bpp");

        System.out.println(wd.search("app"));
        System.out.println(wd.search("ap"));
        System.out.println(wd.search("alp"));
        System.out.println(wd.search("alpi"));
        System.out.println(wd.search("bpp"));
        System.out.println(wd.search("b"));
        System.out.println(wd.search("..pl."));
        System.out.println(wd.search("..pl"));
    }

}
