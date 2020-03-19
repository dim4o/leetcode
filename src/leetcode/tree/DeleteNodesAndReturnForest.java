// Given the root of a binary tree, each node in the tree has a distinct value.
// After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
// Return the roots of the trees in the remaining forest.  You may return the result in any order.
// See: https://leetcode.com/problems/delete-nodes-and-return-forest/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;
import static leetcode.util.tree.BinTreeUtil.printInorder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.util.tree.TreeNode;

public class DeleteNodesAndReturnForest {
    /**
     * The solution is Working and fast enough solution but can be improved
     * TODO: the solution can be done with one recursion
     */
    Set<Integer> set = new HashSet<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (Integer el : to_delete)
            set.add(el);
        TreeNode rootTree = dfs(root);
        if (rootTree != null) res.add(rootTree);
        helper(root);
        
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        
        if (set.contains(root.val)) {
            TreeNode leftTree = dfs(root.left);
            TreeNode rightTree = dfs(root.right);
            if (leftTree != null) res.add(leftTree);
            if (rightTree != null) res.add(rightTree);
        }

        helper(root.left);
        helper(root.right);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null || set.contains(root.val))
            return null;

        TreeNode newNode = new TreeNode(root.val);
        newNode.left = dfs(root.left);
        newNode.right = dfs(root.right);

        return newNode;
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(1,2,3,4,5,6,7);
        List<TreeNode> l1 = new DeleteNodesAndReturnForest().delNodes(t1, new int[] {3, 5});
        for (TreeNode treeNode : l1) {
            printInorder(treeNode);
        }

    }

}
