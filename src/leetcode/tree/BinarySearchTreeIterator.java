// Implement an iterator over a binary search tree (BST). 
// Your iterator will be initialized with the root node of a BST.
// Calling next() will return the next smallest number in the BST.
// See: https://leetcode.com/problems/binary-search-tree-iterator/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class BinarySearchTreeIterator {
    /**
     * This solution flattens the BST. 
     * The drawback of this approach is the O(N) time complexity of calling the constructor
     * TODO: Add a solution with controlled recursion
     */
    class BSTIterator {
        private List<Integer> values = new ArrayList<>();
        private int pos = 0;
        public BSTIterator(TreeNode root) {
            traverseTree(root);
        }
        
        private void traverseTree(TreeNode root) {
            if (root != null) {
                traverseTree(root.left);
                values.add(root.val);
                traverseTree(root.right);
            }
        }
        
        /** @return the next smallest number */
        public int next() {
            return values.get(pos++);
        }
        
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return pos < values.size();
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTreeIterator sln = new BinarySearchTreeIterator();
        TreeNode root = initTree(7, 3, 15, null, null, 9, 20);
        
        BSTIterator iter = sln.new BSTIterator(root);
        
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.hasNext());
    }

}
