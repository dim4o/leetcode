// Given a non-empty binary tree, find the maximum path sum.
// For this problem, a path is defined as any sequence of nodes 
// from some starting node to any node in the tree along the parent-child connections. 
// The path must contain at least one node and does not need to go through the root.
// See: https://leetcode.com/problems/binary-tree-maximum-path-sum/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.util.tree.TreeNode;

public class BinaryTreeMaximumPathSum {
    /**
     * Accepted but slow solution
     * TODO: Find faster alternative
     */
    private long gobalMax = Integer.MIN_VALUE;
    private int tmpMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return (int)gobalMax;
    }

    private void dfs(TreeNode root) {
        if (root == null) 
            return;
        
        tmpMax = Integer.MIN_VALUE;
        dfsHelper(root.left, 0);
        long l = tmpMax;
        
        tmpMax = Integer.MIN_VALUE;
        dfsHelper(root.right, 0);
        long r = tmpMax;
        
        gobalMax = Math.max(gobalMax, l + r + root.val);
        gobalMax = Math.max(gobalMax, Math.max(l + root.val, r + root.val));
        gobalMax = Math.max(gobalMax, root.val);
        
        dfs(root.left);
        dfs(root.right);
    }

    
    private void dfsHelper(TreeNode root, int sum) {
        if (root == null)
            return;
        
        tmpMax = Math.max(tmpMax, sum + root.val);

        dfsHelper(root.left, sum + root.val);
        dfsHelper(root.right, sum + root.val);
    }

    /**
     * Not accepted: Time Limit Exceeded
     */
    int maxSum = 0;

    public int maxPathSum1(TreeNode root) {
        if (root == null)
            return 0;
        maxSum = root.val;
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildAdjGraph(root, null, graph);
        for (TreeNode node : graph.keySet())
            dfs(node, graph, new HashSet<TreeNode>(), node.val);

        return maxSum;
    }

    private void dfs(TreeNode start, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> used,
            int currSum) {
        if (!used.contains(start)) {
            maxSum = Math.max(maxSum, currSum);
            used.add(start);
            List<TreeNode> children = graph.get(start);
            for (TreeNode child : children)
                dfs(child, graph, used, currSum + child.val);
            used.remove(start);
        }
    }

    private void buildAdjGraph(TreeNode root, TreeNode parent,
            Map<TreeNode, List<TreeNode>> graph) {
        if (root == null)
            return;

        if (root.left != null)
            graph.computeIfAbsent(root, k -> new LinkedList<>()).add(root.left);
        if (root.right != null)
            graph.computeIfAbsent(root, k -> new LinkedList<>()).add(root.right);
        if (parent != null)
            graph.computeIfAbsent(root, k -> new LinkedList<>()).add(parent);

        buildAdjGraph(root.left, root, graph);
        buildAdjGraph(root.right, root, graph);
    }

    public static void main(String[] args) {
        TreeNode n1 = initTree(-10, 9, 20, null, null, 15, 7);
        TreeNode n2 = initTree(1, 2, 3);
        TreeNode n3 = initTree(9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6);

//        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(initTree()));
//        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(initTree(1)));
//        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(n1));
//        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(n2));

        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(n3));
    }

}
