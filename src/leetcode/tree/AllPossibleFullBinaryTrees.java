// A full binary tree is a binary tree where each node has exactly 0 or 2 children.
// Return a list of all possible full binary trees with N nodes.  
// Each element of the answer is the root node of one possible tree.
// Each node of each tree in the answer must have node.val = 0.
// You may return the final list of trees in any order.
// See: https://leetcode.com/problems/all-possible-full-binary-trees/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class AllPossibleFullBinaryTrees {

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!map.containsKey(N)) {
            List<TreeNode> res = new LinkedList<TreeNode>();
            if (N == 1)
                res.add(new TreeNode(0));
            else
                for (int i = 1; i < N; i += 2) {
                    List<TreeNode> left = allPossibleFBT(N - i - 1);
                    List<TreeNode> right = allPossibleFBT(i);
                    for (TreeNode currLeft : left)
                        for (TreeNode currRight : right) {
                            TreeNode curr = new TreeNode(0);
                            curr.left = currLeft;
                            curr.right = currRight;
                            res.add(curr);
                        }
                }
            map.put(N, res);
        }

        return map.get(N);
    }

    public static void main(String[] args) {
        List<TreeNode> li = new AllPossibleFullBinaryTrees().allPossibleFBT(7);
        for (TreeNode treeNode : li)
            printInorder(treeNode);

    }

}
