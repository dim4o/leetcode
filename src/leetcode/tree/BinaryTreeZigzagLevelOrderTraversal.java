// Given a binary tree, return the zigzag level order traversal of its nodes' values. 
// (ie, from left to right, then right to left for the next level and alternate between).
// See: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// See: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/653442/Java-DFS-%2B-LinkedList

package leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Solution 2 - DFS + LinkedList
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return new LinkedList<>(dfs(root, 0, new LinkedList<>()));
    }

    private List<LinkedList<Integer>> dfs(TreeNode root, int depth, List<LinkedList<Integer>> list) {
        if (root == null)
            return new LinkedList<>();
        if (list.size() < depth + 1)
            list.add(new LinkedList<>());
        if (depth % 2 == 0)
            list.get(depth).addLast(root.val);
        else
            list.get(depth).addFirst(root.val);
        
        dfs(root.left, depth + 1, list);
        dfs(root.right, depth + 1, list);
        
        return list;
    }
    
    /**
     * Solution 1 - DFS + HashTable
     */
    public List<List<Integer>> zigzagLevelOrder_var1(TreeNode root) {
        final Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        dfs(root, 0, map);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < map.size(); i++)
            ans.add(map.get(i));

        return ans;
    }

    private void dfs(TreeNode root, int depth, Map<Integer, LinkedList<Integer>> map) {
        if (root == null)
            return;
        if (depth % 2 == 0)
            map.computeIfAbsent(depth, k -> new LinkedList<>()).addLast(root.val);
        else
            map.computeIfAbsent(depth, k -> new LinkedList<>()).addFirst(root.val);
        
        dfs(root.left, depth + 1, map);
        dfs(root.right, depth + 1, map);
    }

}
