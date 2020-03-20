// Given the root of a binary search tree with distinct values, modify it so that every node has a new value 
// equal to the sum of the values of the original tree that are greater than or equal to node.val.
// See: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class BinarySearchTreeToGreaterSumTree {
    /**
     * Solution 1 - with a reversed inorder traversal
     */
    int sum = 0;
    public TreeNode bstToGst_2(TreeNode root) {
        reversedInorder(root);
        return root;
    }

    private void reversedInorder(TreeNode root) {
        if (root == null)
            return;
        reversedInorder(root.right);
        root.val = root.val + sum;
        sum = root.val;
        reversedInorder(root.left);
    }

    /**
     * Solution 2 - It was my initial solution. Uses inorder traversal from left to
     * right.
     */
    public TreeNode bstToGst_1(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inorderTraverse(root, list);

        for (int i = list.size() - 2; i >= 0; i--)
            list.get(i).val = list.get(i).val + list.get(i + 1).val;

        return root;
    }

    private void inorderTraverse(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        inorderTraverse(root.left, list);
        list.add(root);
        inorderTraverse(root.right, list);
    }
    
    /**
     * Solution 3 - reversed postorder traversal.
     * This solution seems interesting. I borrowed it from here: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/discuss/537991/Java-time-100-space-100-easy-solution
     */
    public TreeNode bstToGst(TreeNode root) {
        reversedPostorder(root, 0);
        return root;
    }
    
    private int reversedPostorder(TreeNode root, int sum) {
        if (root == null)
            return 0;
        
        int newSum = root.val + reversedPostorder(root.right, sum);
        root.val = newSum + sum;
        return newSum + reversedPostorder(root.left, root.val);
    }

    public static void main(String[] args) {
        BinarySearchTreeToGreaterSumTree sln = new BinarySearchTreeToGreaterSumTree();
        TreeNode t = initTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);

        printInorder(sln.bstToGst(t));
    }

}
