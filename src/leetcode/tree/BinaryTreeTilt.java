package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import leetcode.util.tree.TreeNode;

public class BinaryTreeTilt {
    private int ans = 0;
    public int findTilt(TreeNode root) {
        getSubtreeSum(root);
        return ans;
    }
    
    private int getSubtreeSum(TreeNode root) {
        if (root == null) return 0;
        
        int l = getSubtreeSum(root.left);
        int r = getSubtreeSum(root.right);
        
        ans += Math.abs(l - r);
        
        return root.val + l + r;
    }

    public static void main(String[] args) {
        BinaryTreeTilt sln = new BinaryTreeTilt();
        TreeNode t = initTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        
        System.out.println(sln.getSubtreeSum(t.left));

    }

}
