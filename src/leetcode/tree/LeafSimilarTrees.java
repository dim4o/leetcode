// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
// Return true if and only if the two given trees with head nodes 
// root1 and root2 are leaf-similar.
// See: https://leetcode.com/problems/leaf-similar-trees/

package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> t1Leafs = new ArrayList<>();
        List<Integer> t2Leafs = new ArrayList<>();
        dfs(root1, t1Leafs);
        dfs(root2, t2Leafs);
        
        return t1Leafs.equals(t2Leafs);
    }
    
    private void dfs(TreeNode root,  List<Integer> leafs) {
        if (root == null) {
            return;
        }

        dfs(root.left, leafs);
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }
        dfs(root.right, leafs);
    }

}
