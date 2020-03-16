// Given the root of a tree, you are asked to find the most frequent subtree sum. 
// The subtree sum of a node is defined as the sum of all the node values formed by 
// the subtree rooted at that node (including the node itself). 
// So what is the most frequent subtree sum value? If there is a tie, 
// return all the values with the highest frequency in any order.
// See: https://leetcode.com/problems/most-frequent-subtree-sum/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.TreeNode;

public class MostFrequentSubtreeSum {
    int maxFreq = 1;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumFreq = new HashMap<>(); // sum -> freq
        findSum(root, sumFreq);
        List<Integer> ans = new ArrayList<>();
        for (Integer sum : sumFreq.keySet())
            if (sumFreq.get(sum) == maxFreq)
                ans.add(sum);

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private int findSum(TreeNode root, Map<Integer, Integer> sumFreq) {
        if (root == null)
            return 0;
        int sum = root.val + findSum(root.left, sumFreq) + findSum(root.right, sumFreq);
        if (sumFreq.containsKey(sum)) {
            sumFreq.put(sum, sumFreq.get(sum) + 1);
            maxFreq = Math.max(maxFreq, sumFreq.get(sum));
        } else
            sumFreq.put(sum, 1);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root1 = initTree(5, 2, -5);
        TreeNode root2 = initTree(5, 2, -3);
        new MostFrequentSubtreeSum().findFrequentTreeSum(root1);
        new MostFrequentSubtreeSum().findFrequentTreeSum(root2);
    }

}
