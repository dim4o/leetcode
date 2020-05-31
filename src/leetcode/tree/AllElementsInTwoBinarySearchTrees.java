// Given two binary search trees root1 and root2.
// Return a list containing all the integers from both trees sorted in ascending order.
// See: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class AllElementsInTwoBinarySearchTrees {
    /**
     * Solution 1: Inorder traversal + merge sorted parts.
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        
        // merge
        int i = 0, j = 0;
        while (i < l1.size() || j < l2.size()) 
            if (i < l1.size() && (j == l2.size() || l1.get(i) < l2.get(j)))
                ans.add(l1.get(i++));
            else 
                ans.add(l2.get(j++));
        
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        AllElementsInTwoBinarySearchTrees sln = new AllElementsInTwoBinarySearchTrees();
        System.out.println(sln.getAllElements(initTree(2, 1, 4), initTree(1, 0, 3)));
        System.out.println(sln.getAllElements(initTree(0, -10, -10), initTree(5, 1, 7 ,0, 2)));
    }

}
