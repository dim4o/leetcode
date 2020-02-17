// Given a binary tree, return all root-to-leaf paths.
// https://leetcode.com/problems/binary-tree-paths/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
    
    private void helper(TreeNode root, String curr, List<String> result) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            result.add(curr + root.val);
        }
        
        helper(root.left, curr + root.val + "->", result);
        helper(root.right, curr + root.val + "->", result);
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(1, 2, 3, null, 5);
//        printInorder(t1);
        
        System.out.println(new BinaryTreePaths().binaryTreePaths(t1));
    }

}
