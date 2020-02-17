// Given an n-ary tree, return the level order traversal of its nodes' values.
// Nary-Tree input serialization is represented in their level order traversal, 
// each group of children is separated by the null value (See examples).
// See: https://leetcode.com/problems/n-ary-tree-level-order-traversal/

// TODO: Add queue implementation

package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.tree.Node;

public class NaryTreeLevelOrderTraversal {

    /**
     * The solution uses the preorder traversal
     */
    public List<List<Integer>> levelOrder(Node root) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        helper(root, 0, map);
        return new ArrayList<>(map.values());
    }
    
    private void helper(Node root, int depth, Map<Integer, List<Integer>> map) {
        if (root == null) return;

        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayList<>());
        }
        map.get(depth).add(root.val);
        
        if (root.children != null) {
            for (Node child : root.children) {
                helper(child, depth + 1, map);
            }
        }
    }

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal sln = new NaryTreeLevelOrderTraversal();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.children = Arrays.asList(new Node[] { n3, n2, n4 });
        n3.children = Arrays.asList(new Node[] { n5, n6 });

        System.out.println(sln.levelOrder(n1));
        System.out.println(sln.levelOrder(null));
    }

}
