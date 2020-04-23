// Implement a trie with insert, search, and startsWith methods.
// See: https://leetcode.com/problems/implement-trie-prefix-tree/
// See: https://leetcode.com/problems/implement-trie-prefix-tree/discuss/593601/Java-Concise-Solution

package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    class Trie {
        final class Node {
            final Map<Character, Node> map = new HashMap<>();
            boolean isEnd = false;

            Node() {
            }
        }

        final Node root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                curr.map.computeIfAbsent(ch, k -> new Node());
                curr = curr.map.get(ch);
                if (i == word.length() - 1)
                    curr.isEnd = true;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return find(word, false);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return find(prefix, true);
        }

        private boolean find(String str, boolean isPrefix) {
            Node curr = root;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!curr.map.containsKey(ch))
                    return false;
                curr = curr.map.get(ch);
            }
            return isPrefix ? true : curr.isEnd;
        }
    }

    public static void main(String[] args) {
        Trie trie = new ImplementTriePrefixTree().new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
    }

}
