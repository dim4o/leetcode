// Given a binary tree, return the vertical order traversal of its nodes values.
// See: Given a binary tree, return the vertical order traversal of its nodes values.

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import leetcode.util.tree.TreeNode;

public class VerticalOrderTraversalOfBinaryTree {
    private Map<Integer, List<Integer>> xMap = new TreeMap<>(); // left-right horizontal map
    private Map<Integer, Integer> yMap = new HashMap<>(); // depth map
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>(xMap.values());
        for (List<Integer> list : result)
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer a1, Integer a2) {
                    if (!yMap.get(a1).equals(yMap.get(a2))) 
                       return yMap.get(a2).compareTo(yMap.get(a1));
                    return a1.compareTo(a2);
                }
            });
        return result;
    }
    
    private void dfs(TreeNode root, int x, int y) {
        if (root == null) return;

        List<Integer> currVert = xMap.getOrDefault(x, new ArrayList<>());
        currVert.add(root.val);
        xMap.put(x, currVert);
        yMap.put(root.val, y);
        
        dfs(root.left, x - 1, y - 1);
        dfs(root.right, x + 1, y - 1);
    }

    public static void main(String[] args) {
        VerticalOrderTraversalOfBinaryTree sln = new VerticalOrderTraversalOfBinaryTree();
        
        TreeNode t1 = initTree(1, 2, 3, 4, 5, 6, 7);
        
        List<List<Integer>> res1 = sln.verticalTraversal(t1);
        
        System.out.println(res1);
        System.out.println(sln.xMap);
    }

}
