// Given the root of a binary tree, then value v and depth d, you need to add a row 
// of nodes with value v at the given depth d. The root node is at depth 1.
// See: https://leetcode.com/problems/add-one-row-to-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root != null && d == 1) {
            TreeNode tmp = root;
            root = new TreeNode(v);
            root.left = tmp;
            return root;
        }
        helper(root, v, 1, d);
        return root;
    }

    private void helper(TreeNode root, int v, int currD, int d) {
        if (root == null)
            return;
        
        if (currD == d - 1) {
            TreeNode lTmp = root.left;
            TreeNode rTmp = root.right;

            root.left = new TreeNode(v);
            root.left.left = lTmp;

            root.right = new TreeNode(v);
            root.right.right = rTmp;
        }

        helper(root.left, v, currD + 1, d);
        helper(root.right, v, currD + 1, d);
    }

    public static void main(String[] args) {
        AddOneRowToTree sln = new AddOneRowToTree();
        TreeNode root1 = initTree(4, 2, 6, 3, 1, 5);
        TreeNode root2 = initTree(4, 2, null, 3, 1);
        TreeNode root3 = initTree(3);
        TreeNode root4 = initTree(1, 2, 3, 4);
        TreeNode root5 = initTree(4, 2, 6, 3, 1, 5);

        TreeNode res1 = sln.addOneRow(root1, 1, 2);
        TreeNode res2 = sln.addOneRow(root2, 1, 3);
        TreeNode res3 = sln.addOneRow(root3, 1, 1);
        TreeNode res4 = sln.addOneRow(root4, 5, 4);
        TreeNode res5 = sln.addOneRow(root5, 1, 1);

        printInorder(res1);
        printInorder(res2);
        printInorder(res3);
        printInorder(res4);
        printInorder(res5);
    }

}
