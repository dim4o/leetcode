package com.leetcode.tree;

import static com.leetcode.tree.util.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.tree.util.TreeNode;

public class SymmetricTree {
    
    // TODO: BFS based solution
    // TODO: Full recursive solution

    /**
     * Solution 1 based on DFS algorithm
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        if (root.left != null && root.right != null && root.left.val != root.right.val)
            return false;

        List<Integer> result = new ArrayList<>();
        dfs(root, result);

        int size = result.size();
        for (int i = 0; i < size / 2; i++) {
            if (result.get(i) != result.get(size - i - 1)) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        dfs(root.left, result);

        if (root.left != null && root.right == null) {
            result.add(root.val);
            result.add(null);
        } else if (root.left == null && root.right != null) {
            result.add(null);
            result.add(root.val);
        } else {
            result.add(root.val);
        }

        dfs(root.right, result);
    }

    public static void main(String[] args) {
        SymmetricTree sln = new SymmetricTree();

        TreeNode t1 = initTree(1, 2, 2, 3, 4, 4, 3);
        printInorder(t1);
        System.out.println(sln.isSymmetric(t1));

        TreeNode t2 = initTree(1, 2, 2, null, 3, null, 3);
        printInorder(t2);
        System.out.println(sln.isSymmetric(t2));

        TreeNode t3 = initTree(1, 2, 2, 2, null, 2);
        printInorder(t3);
        System.out.println(sln.isSymmetric(t3));

        TreeNode t4 = initTree(1, 2, 2, null, 3, 3);
        printInorder(t4);
        System.out.println(sln.isSymmetric(t4));

        TreeNode t5 = initTree(5, 4, 1, null, 1, null, 4, 2, null, 2, null);
        printInorder(t5);
        System.out.println(sln.isSymmetric(t5));
    }

}
