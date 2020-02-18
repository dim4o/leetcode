// Given a Binary Search Tree (BST), convert it to a Greater Tree 
// such that every key of the original BST is changed to the original key 
// plus sum of all keys greater than the original key in BST.
// See: https://leetcode.com/problems/convert-bst-to-greater-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;
import static leetcode.util.tree.BinTreeUtil.printInorder;

import leetcode.util.tree.TreeNode;

public class ConvertBSTToGreaterTree {

    private int prev = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {

            convertBST(root.right);

            root.val += prev;
            prev = root.val;

            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(5, 2, 13);

        printInorder(new ConvertBSTToGreaterTree().convertBST(t1));
    }

}
