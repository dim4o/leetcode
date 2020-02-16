// Given a binary tree, return the level order traversal of its nodes' values. 
// (ie, from left to right, level by level).
// See: https://leetcode.com/problems/binary-tree-level-order-traversal/
        
package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> resMap = new LinkedHashMap<Integer, List<Integer>>();
        dfs(root, 0, resMap);

        return new ArrayList<>(resMap.values());
    }

    private void dfs(TreeNode root, int level, Map<Integer, List<Integer>> resultMap) {
        if (root == null)
            return;

        if (!resultMap.containsKey(level)) {
            resultMap.put(level, new ArrayList<>());
        }
        resultMap.get(level).add(root.val);

        dfs(root.left, level + 1, resultMap);
        dfs(root.right, level + 1, resultMap);
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal sln = new BinaryTreeLevelOrderTraversal();

        TreeNode t1 = initTree(3, 9, 20, null, null, 15, 7);
        System.out.println(sln.levelOrder(t1));

        System.out.println(sln.levelOrder(null));
    }
}
