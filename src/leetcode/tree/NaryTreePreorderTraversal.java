// Given an n-ary tree, return the preorder traversal of its nodes' values.
// Nary-Tree input serialization is represented in their level order traversal, 
// each group of children is separated by the null value (See examples).
// See: https://leetcode.com/problems/n-ary-tree-preorder-traversal/

package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.util.tree.Node;

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(Node root, List<Integer> result) {
        if (root == null) return;
        
        result.add(root.val);
        
        if (root.children != null) {
            for (Node child : root.children) {
                helper(child, result);
            }
        }
    }

    public static void main(String[] args) {
        NaryTreePreorderTraversal sln = new NaryTreePreorderTraversal();
        
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.children = Arrays.asList(new Node[] {n3, n2, n4});
        n3.children = Arrays.asList(new Node[] {n5, n6});
        
        System.out.println(sln.preorder(n1));
        System.out.println(sln.preorder(null));
    }

}
