package leetcode.util.test;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import leetcode.util.tree.TreeNode;


class TestBinTreeUtil {
    private class Pair<E> {
        final E input;
        final E expected;
        public Pair(E input, E expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    
    private List<Integer> toList(Integer... values) {
        return Arrays.asList(values);
    }

    @Test
    void test() {
        List<Pair<List<Integer>>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(
                toList(10, 5, 15, null, null, 6, 20), 
                toList(5, 10, 6, 15, 20)));
        
        pairs.add(new Pair<>(
                toList(2, 1, 3),
                toList(1, 2, 3)));
        
        pairs.add(new Pair<>(
                toList(5, 1, 4,null, null, 3, 6),
                toList(1, 5, 3, 4, 6)));
        
        pairs.add(new Pair<>(
                toList(59, null, -71, -6, null, 24),
                toList(59, 24, -6, -71)));
        
        pairs.add(new Pair<>(
                toList(3, 9, 20, null, null, 15, 7),
                toList(9, 3, 15, 20, 7)));
        
        pairs.add(new Pair<>(
                toList(1, 2),
                toList(2, 1)));
        
        pairs.add(new Pair<>(
                toList(1, null, 2),
                toList(1, 2)));
        
        for (Pair<List<Integer>> pair : pairs) {
            List<Integer> input = pair.input;
            List<Integer> expected = pair.expected;
            
            Integer[] inputvalues = (Integer[]) input.toArray();
            TreeNode rootNode = initTree(inputvalues);
            List<Integer> actual = getInorder(rootNode);
            
            Assertions.assertEquals(actual, expected);
        }

    }

}
