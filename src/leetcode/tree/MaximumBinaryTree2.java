// See: https://leetcode.com/problems/maximum-binary-tree-ii/

package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class MaximumBinaryTree2 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> flattenList = new ArrayList<>();
        dfs(root, flattenList);
        flattenList.add(val);
        
        return construct(flattenList, 0, flattenList.size() - 1);
    }
    
    private TreeNode construct(List<Integer> nums, int start, int end) {
        if (start > end)
            return null;

        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode curr = new TreeNode(nums.get(maxIndex));

        curr.left = construct(nums, start, maxIndex - 1);
        curr.right = construct(nums, maxIndex + 1, end);

        return curr;
    }

    private int findMaxIndex(List<Integer> nums, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++)
            if (nums.get(i) > nums.get(maxIndex)) 
                maxIndex = i;
        return maxIndex;
    }
    
    private void dfs(TreeNode root, List<Integer> flattenTree) {
        if (root == null) return;
        dfs(root.left, flattenTree);
        flattenTree.add(root.val);
        dfs(root.right, flattenTree);
    }

    public static void main(String[] args) {

    }

}
