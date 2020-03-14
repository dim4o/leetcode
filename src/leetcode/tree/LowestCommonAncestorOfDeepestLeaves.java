// Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.
// See: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
// Note: This problem seems to be duplicate of the following: 
// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/ 

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves {
    private int maxDepth = 0;
    private Map<Integer, List<TreeNode>> map = new HashMap<>();

    /**
     * This is not the optimal solution but because the task is duplicated (see the node above)
     * I put the optimal solution in the duplicated problem: 
     * @see: leetcode.tree.SmallestSubtreeWithallTheDeepestNodes
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findDeepest(root, 0);
        List<TreeNode> deepestNodes = map.get(maxDepth);
        TreeNode currLca = deepestNodes.get(0);
        for (TreeNode node : deepestNodes)
            currLca = lca(root, currLca, node);

        return currLca;
    }

    private void findDeepest(TreeNode root, int d) {
        if (root == null) return;
        maxDepth = Math.max(maxDepth, d);
        List<TreeNode> l = map.getOrDefault(d, new ArrayList<>());
        l.add(root);
        map.put(d, l);
        findDeepest(root.left, d + 1);
        findDeepest(root.right, d + 1);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode l = lca(root.left, p, q);
        TreeNode r = lca(root.right, p, q);
        if (l != null && r != null) return root;
        return l != null ? l : r;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfDeepestLeaves sln = new LowestCommonAncestorOfDeepestLeaves();
        TreeNode r1 = initTree(1, 2, 3, 4);
        TreeNode r2 = initTree(1, 2, 3, 4, 5);
        System.out.println(sln.lcaDeepestLeaves(r1).val);
        System.out.println(sln.lcaDeepestLeaves(r2).val);
    }

}
