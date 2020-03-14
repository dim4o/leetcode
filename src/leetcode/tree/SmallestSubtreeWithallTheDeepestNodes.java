// Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
// A node is deepest if it has the largest depth possible among any node in the entire tree.
// The subtree of a node is that node, plus the set of all descendants of that node.
// Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
// See: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
// Note: This problem seems to be duplicate of the following: 
// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.tree.TreeNode;

/**
 * For another solution: @see: leetcode.tree.LowestCommonAncestorOfDeepestLeaves
 */
public class SmallestSubtreeWithallTheDeepestNodes {
    private int maxDepth = 0;
    private final Map<TreeNode, Integer> depthMap = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        createDepthMap(root, 0);
        return findSubree(root);
    }

    private TreeNode findSubree(TreeNode root) {
        if (root == null || depthMap.get(root) == maxDepth)
            return root;

        TreeNode l = findSubree(root.left);
        TreeNode r = findSubree(root.right);
        if (l != null && r != null)
            return root;

        return l != null ? l : r;
    }

    private void createDepthMap(TreeNode root, int depth) {
        if (root == null)
            return;
        depthMap.put(root, depth);
        maxDepth = Math.max(maxDepth, depth);
        createDepthMap(root.left, depth + 1);
        createDepthMap(root.right, depth + 1);
    }

    public static void main(String[] args) {
        SmallestSubtreeWithallTheDeepestNodes sln = new SmallestSubtreeWithallTheDeepestNodes();
        TreeNode r1 = initTree(1, 2, 3, 4);
        TreeNode r2 = initTree(1, 2, 3, 4, 5);
        TreeNode r3 = initTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        System.out.println(sln.subtreeWithAllDeepest(r1).val); // 4
        System.out.println(sln.subtreeWithAllDeepest(r2).val); // 2
        System.out.println(sln.subtreeWithAllDeepest(r3).val); // 2
    }

}
