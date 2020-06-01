// Populate each next pointer to point to its next right node. If there is no next right node, 
// the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.
// See: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// See: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/664580/Java-Concise-recursion

package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode2 {

    public Node connect(Node root) {
        return helper(root, 0, new ArrayList<>());
    }
    
    private Node helper(Node root, int depth, List<Node> nodes) {
        if (root == null) return null;
        
        if (depth < nodes.size()) {
            nodes.get(depth).next = root;
            nodes.set(depth, root);
        } else nodes.add(root);
        
        helper(root.left, depth + 1, nodes);
        helper(root.right, depth + 1, nodes);
        
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode2 sln = new PopulatingNextRightPointersInEachNode2();
        
        Node n1 = sln.new Node(1);
        Node n2 = sln.new Node(2);
        Node n3 = sln.new Node(3);
        Node n4 = sln.new Node(4);
        Node n5 = sln.new Node(5);
        Node n7 = sln.new Node(7);
        
        n1.left = n2;
        n1.right = n3;
        n3.right = n7;
        n2.left = n4;
        n2.right = n5;
        
        Node n = sln.connect(n1);
        System.out.println(n);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
