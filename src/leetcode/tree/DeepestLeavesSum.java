// Given a binary tree, return the sum of values of its deepest leaves.
// See: https://leetcode.com/problems/deepest-leaves-sum/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.util.tree.TreeNode;

public class DeepestLeavesSum {

    /**
     * BFS approach.
     */
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        int deepestLeavesSum = 0;
        int count = 1;
        int levelCount = 1;
        while (!q.isEmpty()) {
            count--;
            if (count == 0) {
                int sum = 0;
                for (TreeNode treeNode : q)
                    sum += treeNode.val;
                count = levelCount;
                levelCount = 0;
                deepestLeavesSum = sum;
            }
            TreeNode curr = q.poll();

            if (curr.left != null) {
                q.add(curr.left);
                levelCount++;
            }
            if (curr.right != null) {
                q.add(curr.right);
                levelCount++;
            }
        }
        return deepestLeavesSum;
    }

    /**
     * DFS approach. O(n) time. O(log(n)) space for the average case. O(n) for the
     * worst case when the tree is linked list.
     */
    private int maxDepth = 0;
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public int deepestLeavesSum_var1(TreeNode root) {
        dfs(root, 0);
        return map.get(maxDepth).stream().reduce((a, b) -> a + b).get();
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        maxDepth = Math.max(maxDepth, depth);
        map.computeIfAbsent(depth, k -> new ArrayList<>()).add(root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public static void main(String[] args) {
        DeepestLeavesSum sln = new DeepestLeavesSum();
        TreeNode root = initTree(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8);

        System.out.println(sln.deepestLeavesSum(root));

    }

}
