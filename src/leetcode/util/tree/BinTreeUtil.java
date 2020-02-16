package leetcode.util.tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreeUtil {
    public static TreeNode initTree(Integer... values) {
        if (values.length == 0) {
            return null;
        }
        TreeNode[] treeArr = new TreeNode[values.length];
        for (int i = 0; i < treeArr.length; i++) {
            if (values[i] != null) {
                treeArr[i] = new TreeNode(values[i]);
            }
        }
        
        int leftIndex = 1;
        int rightIndex = 2;
        TreeNode root = treeArr[0];

        for (int i = 0; i < treeArr.length; i++) {
            if (leftIndex >= treeArr.length) {
                return treeArr[0];
            }
            root = treeArr[i];
            if (root != null) {
                root.left = treeArr[leftIndex];
                if (rightIndex < treeArr.length) {
                    root.right = treeArr[rightIndex];
                }
                leftIndex += 2;
                rightIndex += 2;
            }
        }
        return treeArr[0];
    }
    
    public static void printInorder(TreeNode root) {
        System.out.println(getInorder(root));
    }
    
    public static List<Integer> getInorder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, result);

        return result;
    }
    
    private static void dfs(TreeNode root, List<Integer> res) {
        if (root != null) {
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
        }
    }
}
