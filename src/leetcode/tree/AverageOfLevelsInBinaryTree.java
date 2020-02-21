// Given a non-empty binary tree, return the average value of 
// the nodes on each level in the form of an array.
// See: https://leetcode.com/problems/average-of-levels-in-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> avgMap = new LinkedHashMap<>();
        List<Double> result = new ArrayList<>();
        
        dfs(root, 0, avgMap);
        
        for (int key : avgMap.keySet()) {
            Double average = (avgMap.get(key))
                    .stream().mapToDouble(val -> val).average().orElse(0.0);
            result.add(average);
        }
        
        return result;
    }
    
    private void dfs(TreeNode root, int depth, Map<Integer, List<Integer>> avgMap) {
        if (root == null) return;

        if (!avgMap.containsKey(depth)) {
            avgMap.put(depth, new ArrayList<>());
        }
        
        avgMap.get(depth).add(root.val);
        dfs(root.left, depth + 1, avgMap);
        dfs(root.right, depth + 1, avgMap);
    }
    
    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree sln = new AverageOfLevelsInBinaryTree();
        TreeNode t1 = initTree(3, 9, 20, null, null, 15, 7);
        System.out.println(sln.averageOfLevels(t1));
    }

}
