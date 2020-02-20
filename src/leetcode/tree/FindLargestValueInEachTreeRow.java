// You need to find the largest value in each row of a binary tree.
// See: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> maxMap = new LinkedHashMap<>();
        dfs(root, 0, maxMap);
        return new ArrayList<Integer>(maxMap.values());
    }
    
    private void dfs(TreeNode root, int depth, Map<Integer, Integer> maxMap) {
        if (root == null) {
            return;
        }

        if (root.val >= maxMap.getOrDefault(depth, Integer.MIN_VALUE)) {
            maxMap.put(depth, root.val);
        }

        dfs(root.left, depth + 1, maxMap);
        dfs(root.right, depth + 1, maxMap);
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow sln = new FindLargestValueInEachTreeRow();
        TreeNode t1 = initTree(1, 3, 2, 5, 3, null, 9);
        
        System.out.println(sln.largestValues(t1));
        System.out.println(sln.largestValues(null));
        System.out.println(sln.largestValues(new TreeNode(-2147483648)));
    }

}
