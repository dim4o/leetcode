// Given an n-ary tree, return the postorder traversal of its nodes' values.
// Nary-Tree input serialization is represented in their level order traversal, 
// each group of children is separated by the null value (See examples).
// See: https://leetcode.com/problems/n-ary-tree-postorder-traversal/

package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.util.tree.Node;

public class NaryTreePostorderTraversal {
    
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(Node root, List<Integer> result) {
        if (root == null) return;
        
        if (root.children != null) {
            for (Node child : root.children) {
                helper(child, result);
            }
        }
        
        result.add(root.val);
    }

    public static void main(String[] args) {
        NaryTreePostorderTraversal sln = new NaryTreePostorderTraversal();
        
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.children = Arrays.asList(new Node[] {n3, n2, n4});
        n3.children = Arrays.asList(new Node[] {n5, n6});
        
        System.out.println(sln.postorder(n1));
        System.out.println(sln.postorder(null));
    }
}
