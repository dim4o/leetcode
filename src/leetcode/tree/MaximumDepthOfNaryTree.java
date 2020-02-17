// Given a n-ary tree, find its maximum depth.
// The maximum depth is the number of nodes along 
// the longest path from the root node down to the farthest leaf node.
// See: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;

import leetcode.util.tree.Node;

public class MaximumDepthOfNaryTree {
    private int maxDepth = 0;
    
    public int maxDepth(Node root) {
        helper(root, 1);
        return maxDepth;
    }
    
    private void helper(Node root, int depth) {
        if (root == null) return;
        
        if (root.children.isEmpty() && depth > maxDepth) {
            maxDepth = depth;
        }
        
        if (root.children != null) {
            for (Node child : root.children) {
                helper(child, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());
        n1.children = Arrays.asList(new Node[] { n3, n2, n4 });
        n3.children = Arrays.asList(new Node[] { n5, n6 });

        System.out.println(new MaximumDepthOfNaryTree().maxDepth(n1));
        System.out.println(new MaximumDepthOfNaryTree().maxDepth(null));
    }

}
