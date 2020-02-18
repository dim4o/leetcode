// Given a binary search tree (BST) with duplicates, 
// find all the mode(s) (the most frequently occurred element) in the given BST.
// See: https://leetcode.com/problems/find-mode-in-binary-search-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class FindModeInBinarySearchTree {
    
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        
        List<Integer> modes = new ArrayList<>();
        
        int maxModeValue = 1;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() > maxModeValue) {
                maxModeValue = pair.getValue();
            }
        }
        
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == maxModeValue) {
                modes.add(pair.getKey());
            }
        }

        return modes.stream().mapToInt(i->i).toArray();
    }
    
    public void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }

    public static void main(String[] args) {
        FindModeInBinarySearchTree sln = new FindModeInBinarySearchTree();
        TreeNode t1 = initTree(1, null, 2, 2);
        
        System.out.println(Arrays.toString(sln.findMode(t1)));
    }

}
