// Given a binary tree, return the postorder traversal of its nodes' values.
// Recursive solution is trivial, could you do it iteratively?
// See: https://leetcode.com/problems/binary-tree-postorder-traversal/
   
package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import leetcode.util.tree.TreeNode;

public class BinaryTreePostorderTraversal {
    // TODO: Add more effective stack based solution
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Map<TreeNode, Boolean> hasChilren = new HashMap<>();
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        
        while (!s.isEmpty()) {
            TreeNode curr = s.peek();
            if ((curr.left == null && curr.right == null) ^ !hasChilren.getOrDefault(curr, true)) {
                res.add(s.pop().val);
                continue;
            }
            
            if (curr.right != null)
                s.add(curr.right);
            
            if(curr.left != null)
                s.add(curr.left);

            hasChilren.put(curr, false);
        }
        
        return res;
    }
    
    @SuppressWarnings("unused")
    private void postOrd(TreeNode root) {
        if (root == null) return;
        postOrd(root.left);
        postOrd(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal sln = new BinaryTreePostorderTraversal();
        TreeNode t1 = initTree(1, 0, 4, 2, 3, 5, null);
        TreeNode t2 = initTree(5, 3, 7, 1, 4, 6, 8);
//        printInorder(t2);
//        sln.postOrd(t2);
        System.out.println(sln.postorderTraversal(t1));
        System.out.println(sln.postorderTraversal(t2));
        System.out.println(sln.postorderTraversal(null));
        System.out.println(sln.postorderTraversal(initTree(1)));
    }

}
