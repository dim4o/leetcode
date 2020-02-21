// Given a Binary Search Tree and a target number, return true if there exist 
// two elements in the BST such that their sum is equal to the given target.
// See: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.tree.TreeNode;

public class TwoSum4InputBST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        
        return dfs(root, set, k);
    }
    
    private boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        
        if (set.contains(root.val)) {
            return true;
        } else {
            set.add(k -root.val);
        }
        
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    public static void main(String[] args) {
        TwoSum4InputBST sln = new TwoSum4InputBST();
        TreeNode t1 = initTree(5, 3, 6, 2, 4, null, 7);
        
        System.out.println(sln.findTarget(t1, 9));
        System.out.println(sln.findTarget(t1, 28));
    }

}
