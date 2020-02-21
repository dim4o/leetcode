// You need to construct a string consists of parenthesis and integers 
// from a binary tree with the preorder traversing way.
// See: https://leetcode.com/problems/construct-string-from-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class ConstructStringFromBinaryTree {
   

    public String tree2str(TreeNode root) {
        if (root == null) return "";    
        
        String left = "";
        String right = "";
        
        if (root.left != null && root.right != null) {
            left = "(" + tree2str(root.left) + ")";
            right = "(" + tree2str(root.right) + ")";
        } 
        else if (root.left != null && root.right == null) {
            left = "(" + tree2str(root.left) + ")";
        } else if (root.left == null && root.right != null) {
            left = "()";
            right = "(" + tree2str(root.right) + ")";
        }
        
        return root.val + left + right;
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree sln = new ConstructStringFromBinaryTree();
        TreeNode t1 = initTree(1, 2, 3, 4);
        TreeNode t2 = initTree(1, 2, 3, null, 4);

        System.out.println(sln.tree2str(t1));
        System.out.println(sln.tree2str(t2));
    }

}
