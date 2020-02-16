// Given a binary tree, return the bottom-up level order traversal of 
// its nodes' values. (ie, from left to right, level by level from leaf to root).
// See: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> resMap = new LinkedHashMap<Integer, List<Integer>>();
        dfs(root, 0, resMap);

        List<List<Integer>> res = new ArrayList<>(resMap.values());
        Collections.reverse(res);

        return res;
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
        BinaryTreeLevelOrderTraversal_II sln = new BinaryTreeLevelOrderTraversal_II();

        TreeNode t1 = initTree(3, 9, 20, null, null, 15, 7);
        System.out.println(sln.levelOrderBottom(t1));

        System.out.println(sln.levelOrderBottom(null));
    }
}
