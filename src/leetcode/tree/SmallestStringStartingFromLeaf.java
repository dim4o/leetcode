// Find the lexicographically smallest string 
// that starts at a leaf of this tree and ends at the root.
// See: https://leetcode.com/problems/smallest-string-starting-from-leaf/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class SmallestStringStartingFromLeaf {
    private String ans = "{";

    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return ans;
    }

    public void helper(TreeNode root, String curr) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            String candidate = (char) (root.val + 97) + curr;
            if (candidate.compareTo(ans) < 0) {
                ans = candidate;
            }
        }

        helper(root.left, (char) (root.val + 97) + curr);
        helper(root.right, (char) (root.val + 97) + curr);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestStringStartingFromLeaf()
                .smallestFromLeaf(initTree(0, 1, 2, 3, 4, 3, 4)));
        
        System.out.println(new SmallestStringStartingFromLeaf()
                .smallestFromLeaf(initTree(25, 1, 3, 1, 3, 0, 2)));
        
        System.out.println(new SmallestStringStartingFromLeaf()
                .smallestFromLeaf(initTree(2, 2, 1, null, 1, 0, null, 0)));
        
        System.out.println(new SmallestStringStartingFromLeaf().
                smallestFromLeaf(initTree(3, 9, 20, null, null, 15, 7)));
    }
}
