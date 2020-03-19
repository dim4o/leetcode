// Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
// Return the root node reference (possibly updated) of the BST.
// See: https://leetcode.com/problems/delete-node-in-a-bst/
// See: https://leetcode.com/problems/delete-node-in-a-bst/discuss/544606/Fast-and-Concise-Recursive-Solution-with-Comments
package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class DeleteNodeInBST {

    /**
     * There are 3 cases: 
     *     - Delete a leaf 
     *     - Delete a node with one child by replacing it with it's child 
     *     - Delete a node with two children
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || root.val == key && root.left == null && root.right == null)
            // Case 1. The node is leaf
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (root.right == null)
            // Case 2. the node has left child
            return root.left;
        else if (root.left == null) 
            // Case 2. the node has right child
            return root.right;
        else {
            // Case 3. The node has two children
            TreeNode curr = root;
            curr = curr.right;
            // Finds the closest bigger node
            while (curr.left != null)
                if (curr.left != null) curr = curr.left;
            // Assign the closest value and delete the closest node (Case 1 or Case 2)
            root.val = curr.val;
            root.right = deleteNode(root.right, curr.val);
        }

        return root;
    }

    public static void main(String[] args) {
        DeleteNodeInBST sln = new DeleteNodeInBST();

        TreeNode t1 = initTree(5, 3, 6, 2, 4, null, 7);
        TreeNode res = sln.deleteNode(t1, 5);
        printInorder(res);
    }

}
