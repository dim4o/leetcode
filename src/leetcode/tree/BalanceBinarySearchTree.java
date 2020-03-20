// Given a binary search tree, return a balanced binary search tree with the same node values.
// A binary search tree is balanced if and only if the depth of the two subtrees of every node 
// never differ by more than 1.
// If there is more than one answer, return any of them.
// See: https://leetcode.com/problems/balance-a-binary-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class BalanceBinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        dfs(root, sortedList);

        return constructBalancedBST(sortedList, 0, sortedList.size() - 1);
    }

    private TreeNode constructBalancedBST(List<Integer> sortedList, int l, int r) {
        if (l > r)
            return null;

        int mid = (l + r) / 2;
        TreeNode currNode = new TreeNode(sortedList.get(mid));
        currNode.left = constructBalancedBST(sortedList, l, mid - 1);
        currNode.right = constructBalancedBST(sortedList, mid + 1, r);

        return currNode;
    }

    private void dfs(TreeNode root, List<Integer> sortedList) {
        if (root == null)
            return;
        dfs(root.left, sortedList);
        sortedList.add(root.val);
        dfs(root.right, sortedList);
    }

    public static void main(String[] args) {
        TreeNode t1 = initTree(1, null, 2, null, 3, null, 4, null, null);
        TreeNode res = new BalanceBinarySearchTree().balanceBST(t1);
        printInorder(res);
    }
}
