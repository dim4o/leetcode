// Lowest Common Ancestor of a Binary Tree
// See: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.tree.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    // TODO: Add more optimal solution
    // Working but slow solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        boolean l = find(root.left, p, q);
        boolean r = find(root.right, p, q);
        if (l && r)
            return root;
        if (root.val == p.val && (l || r))
            return root;
        if (root.val == q.val && (l || r))
            return root;

        TreeNode t1 = lowestCommonAncestor(root.left, p, q);
        TreeNode t2 = lowestCommonAncestor(root.right, p, q);

        return t1 == null ? t2 : t1;
    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        if (root.val == p.val || root.val == q.val)
            return true;
        return find(root.left, p, q) || find(root.right, p, q);
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTree sln = new LowestCommonAncestorOfBinaryTree();
        TreeNode t = initTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        System.out.println(sln.lowestCommonAncestor(t, new TreeNode(5), new TreeNode(1)).val); // 3
        System.out.println(sln.lowestCommonAncestor(t, new TreeNode(5), new TreeNode(4)).val); // 5
        System.out.println(sln.lowestCommonAncestor(t, new TreeNode(4), new TreeNode(6)).val);
    }
    
    // Buggy solution. The idea is to compare the paths from the root to node "p" and "q".
    // The last common value between the paths should be the LCA but for some reasons
    // fails to pass all test cases
    public TreeNode lowestCommonAncestor_buggy(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        findPath(root, p, l1);
        findPath(root, q, l2);
        // System.out.println(l1);
        // System.out.println(l2);
        int len = Math.min(l1.size(), l2.size());
        for (int i = 0; i < len; i++)
            if (l1.get(i) != l2.get(i))
                return new TreeNode(l1.get(i - 1));
        
        return new TreeNode(l1.get(len - 1));
    }
    public boolean findPath(TreeNode root, TreeNode target, List<Integer> path) {
        if (root == null)
            return false;

        path.add(root.val);
        if (root.val == target.val)
            return true;
 
        boolean l = findPath(root.left, target, path);
        boolean r = findPath(root.right, target, path);
        if (!(l | r)) 
            path.remove(path.size() - 1);

        return l | r;
    }

}
