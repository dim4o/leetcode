// Two nodes of a binary tree are cousins if they have the same depth, 
// but have different parents.
// Return true if and only if the nodes corresponding to the values x and y are cousins.
// See: https://leetcode.com/problems/cousins-in-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import leetcode.util.tree.TreeNode;

public class CousinsInBinaryTree {

    /**
     * Depth First Search approach.
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        dfs(root, parentMap, null, depthMap, 0);
        
        return depthMap.get(x) == depthMap.get(y) && parentMap.get(x) != parentMap.get(y);
    }

    private void dfs(TreeNode root, 
            Map<Integer, Integer> parentMap, Integer parent, 
            Map<Integer, Integer> depthMap, Integer depth) {
        if (root == null) {
            return;
        }

        parentMap.put(root.val, parent);
        depthMap.put(root.val, depth);
        dfs(root.left, parentMap, root.val, depthMap, depth + 1);
        dfs(root.right, parentMap, root.val, depthMap, depth + 1);
    }

    /**
     * Breath Search First solution.
     */
    public boolean isCousins_BFS(TreeNode root, int x, int y) {
        int depth = 0;
        Map<Integer, Integer> depthMap = new HashMap<>();

        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(root.val, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            Set<Integer> currLevel = new HashSet<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode currNode = q.poll();

                currLevel.add(currNode.val);

                if (currNode.left != null) {
                    q.add(currNode.left);
                    parentMap.put(currNode.left.val, currNode.val);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                    parentMap.put(currNode.right.val, currNode.val);
                }
                depthMap.put(currNode.val, depth);
            }
            depth += 1;
        }

        return depthMap.get(x) == depthMap.get(y) && parentMap.get(x) != parentMap.get(y);
    }

    public static void main(String[] args) {
        CousinsInBinaryTree sln = new CousinsInBinaryTree();

        TreeNode t1 = initTree(1, 2, 3, 4, 5, 6, null);
        TreeNode t2 = initTree(1, 2, 3, null, 4, null, 5);
        TreeNode t3 = initTree(1, 2, 3, null, 4);

        System.out.println(sln.isCousins(t1, 4, 3)); // false
        System.out.println(sln.isCousins(t2, 5, 4)); // true
        System.out.println(sln.isCousins(t3, 2, 3)); // false
    }

}
