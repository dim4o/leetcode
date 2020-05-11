// Given a non-empty special binary tree consisting of nodes with the non-negative value, 
// where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, 
// then this node's value is the smaller value among its two sub-nodes. 
// More formally, the property root.val = min(root.left.val, root.right.val) always holds.
// Given such a binary tree, you need to output the second minimum value in the set made 
// of all the nodes' value in the whole tree.
// If no such second minimum value exists, output -1 instead.
// See: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.TreeSet;

import leetcode.util.tree.TreeNode;

public class SecondMinimumNodeInBinaryTree {

    /*
     * Solution 2 - O(n) time (faster than Solution 1).
     * TODO: The solution can be optimized by removing the need of Long value.
     */
    private Integer min = null;
    private long secondMin = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        helper(root);
        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        if (root.val - min > 0 )
            secondMin = Math.min(secondMin, root.val);
        
        int currMin = Math.min(min, root.val);
        if (currMin < min) {
            secondMin = min;
            min = currMin;
        }

        helper(root.left);
        helper(root.right);
    }

    /**
     * Solution 1 - Initial solution (naive but easy). O(n.log(n)) time, O(n) space.
     */
    private final TreeSet<Integer> treeSet = new TreeSet<>();

    public int findSecondMinimumValue_var1(TreeNode root) {
        dfs(root);
        if (treeSet.size() < 2)
            return -1;
        return (int) treeSet.toArray()[1];
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        treeSet.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new SecondMinimumNodeInBinaryTree()
                .findSecondMinimumValue(initTree(2, 3, 2, 3, 4)));
        System.out.println(new SecondMinimumNodeInBinaryTree()
                .findSecondMinimumValue(initTree(2, 2, 2147483647)));
        System.out.println(
                new SecondMinimumNodeInBinaryTree().findSecondMinimumValue(initTree(2, 2, 2)));
    }

}
