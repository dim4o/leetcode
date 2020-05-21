// We are given a binary tree (with root node root), a target node, and an integer value K.
// Return a list of the values of all nodes that have a distance K from the target node.  
// The answer can be returned in any order.
// See: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.util.tree.TreeNode;

public class AllNodesDistanceKinBinaryTree {
    /**
     * TODO: Solution 3: Build a graph/parent map and then do BFS with depth == K from target.
     * TODO: Solution 4: Percolate Distance
     */

    /**
     * Solution 2: Build a graph and then do DFS with depth == K from target.
     */
    final Map<Integer, List<TreeNode>> graph = new HashMap<>();
    final Set<Integer> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        buildGraph(root);
        visited.add(target.val);
        traverse(target, 0, K, res);
        return res;
    }
    
    private void traverse(TreeNode root, int depth, int K, List<Integer> res) {
        if (depth == K) {
            res.add(root.val);
            return;
        }
        
        for (TreeNode child : graph.getOrDefault(root.val, new LinkedList<>())) {
            if (!visited.contains(child.val)) {
                visited.add(child.val);
                traverse(child, depth + 1, K, res);
            }
        }
    }

    private void buildGraph(TreeNode root) {
        if (root.left != null) {
            graph.computeIfAbsent(root.val, k -> new LinkedList<>()).add(root.left);
            graph.computeIfAbsent(root.left.val, k -> new LinkedList<>()).add(root);
            buildGraph(root.left);
        }
        if (root.right != null) {
            graph.computeIfAbsent(root.val, k -> new LinkedList<>()).add(root.right);
            graph.computeIfAbsent(root.right.val, k -> new LinkedList<>()).add(root);
            buildGraph(root.right);
        }
    }

    /**
     * Solution 1: Build a parent map and then do DFS with depth == K from target.
     */
    private final Map<Integer, TreeNode> parentMap = new HashMap<>();
    private final Set<Integer> used = new HashSet<>();

    public List<Integer> distanceK_var1(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        buildParenMap(root);
        dfs(target, 0, K, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, int K, List<Integer> res) {
        if (root == null)
            return;

        if (depth == K) {
            res.add(root.val);
            return;
        }

        if (!used.contains(root.val)) {
            used.add(root.val);
            dfs(parentMap.get(root.val), depth + 1, K, res);
        }
        if (root.left != null && !used.contains(root.left.val)) {
            used.add(root.left.val);
            dfs(root.left, depth + 1, K, res);
        }
        if (root.right != null && !used.contains(root.right.val)) {
            used.add(root.right.val);
            dfs(root.right, depth + 1, K, res);
        }
    }

    private void buildParenMap(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            parentMap.put(root.left.val, root);
        if (root.right != null)
            parentMap.put(root.right.val, root);
        buildParenMap(root.left);
        buildParenMap(root.right);
    }

    public static void main(String[] args) {
        AllNodesDistanceKinBinaryTree sln = new AllNodesDistanceKinBinaryTree();

        TreeNode root = initTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        // Test building a map/graph
        sln.buildGraph(root);
        sln.buildParenMap(root);
    }
}
