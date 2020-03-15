// Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, 
// you only need to return the root node of any one of them.
// Two trees are duplicate if they have the same structure with same node values.
// See: https://leetcode.com/problems/find-duplicate-subtrees/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.util.tree.TreeNode;

public class FindDuplicateSubtrees {
    private final Map<String, TreeNode> serializeMap = new HashMap<>();
    private final Set<String> serSet = new HashSet<>();
    private final List<TreeNode> duplicates = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return duplicates;
    }

    /**
     * Note: StringBuilder may increase the performance here
     */
    private String serialize(TreeNode root) {
        if (root == null)
            return "|";
        // Note: the more accurate expression is:
        // root.val + "," + serialize(root.left) + "," + serialize(root.right)
        // because of duality in the representation
        // For example: "5555" can represent both triple ("5", "55", "5") and ("55", "5", "5")
        String ser = root.val + serialize(root.left) + serialize(root.right);
        if (serializeMap.containsKey(ser) && !serSet.contains(ser)) {
            duplicates.add(root);
            serSet.add(ser);
        } else 
            serializeMap.put(ser, root);
        
        return ser;
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees sln = new FindDuplicateSubtrees();
        TreeNode t = initTree(1, 2, 3, 4, null, 2, 4, null, null, 4);
        List<TreeNode> list = sln.findDuplicateSubtrees(t);
        
        System.out.println(list);
    }
}
