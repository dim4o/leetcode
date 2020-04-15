// Design an Iterator class, which has:
//      - A constructor that takes a string characters of sorted distinct lowercase 
//        English letters and a number combinationLength as arguments.
//      - A function next() that returns the next combination of length 
//        combinationLength in lexicographical order.
//      - A function hasNext() that returns True if and only if there exists 
//        a next combination.
// See: https://leetcode.com/problems/iterator-for-combination/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IteratorForCombination {

    public class CombinationIterator {
        private List<String> combinations = null;
        private int currIndex;

        public CombinationIterator(String characters, int combinationLength) {
            this.combinations = new ArrayList<>();
            this.comb(characters, combinations, new StringBuilder(), combinationLength, 0);
            this.currIndex = -1;
        }

        public String next() {
            currIndex++;
            return this.combinations.get(currIndex);
        }

        public boolean hasNext() {
            return currIndex < combinations.size() - 1;
        }

        private void comb(String seq, List<String> res, StringBuilder currRes, int k, int start) {
            if (currRes.length() == k) {
                res.add(currRes.toString());
                return;
            }

            for (int i = start; i < seq.length(); i++) {
                currRes.append(seq.charAt(i));
                comb(seq, res, currRes, k, i + 1);
                currRes.setLength(currRes.length() - 1);
            }

        }
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new IteratorForCombination().new CombinationIterator("abc", 2);

        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
    }

}
