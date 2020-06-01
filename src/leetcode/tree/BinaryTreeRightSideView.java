// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes 
// you can see ordered from top to bottom.
// See: https://leetcode.com/problems/binary-tree-right-side-view/

package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class BinaryTreeRightSideView {

    /**
     * Solution 1: Easy initial solution. 
     * Time complexity: O(N), Space complexity: O(N)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        createView(root, 0, ans);
        // createViewOpt(root, 0, ans);
        return ans;
    }

    private void createView(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;

        if (depth < list.size())
            list.set(depth, root.val);
        else list.add(root.val);
        
        createView(root.left, depth + 1, list);
        createView(root.right, depth + 1, list);
    }
    
    /**
     * Optimized version
     */
    @SuppressWarnings("unused")
    private void createViewOpt(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;

        if (depth == list.size())
            list.add(root.val);
        
        createViewOpt(root.right, depth + 1, list);
        createViewOpt(root.left, depth + 1, list);
    }

}
