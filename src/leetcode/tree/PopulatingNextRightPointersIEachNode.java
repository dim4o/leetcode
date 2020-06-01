// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
// Populate each next pointer to point to its next right node. If there is no next right node, 
// the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.
// See: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// See: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/664289/Java-Really-simple-DFS

package leetcode.tree;

public class PopulatingNextRightPointersIEachNode {

    public Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }

    // Definition for a Node.
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
