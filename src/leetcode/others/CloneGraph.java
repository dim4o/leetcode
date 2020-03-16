// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.
// See: https://leetcode.com/problems/clone-graph/

package leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    /**
     * BFS solution.
     * TODO: Add DFS solution.
     */
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> used = new HashMap<>();

        Node copy = new Node(node.val);
        Node res = copy; // pointer to the start node

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        used.put(node.val, copy);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            copy = used.get(curr.val);
            for (Node neighbor : curr.neighbors) {
                if (!used.containsKey(neighbor.val)) {
                    Node copyNode = new Node(neighbor.val);
                    copy.neighbors.add(copyNode);
                    q.add(neighbor);
                    used.put(neighbor.val, copyNode);
                } else
                    copy.neighbors.add(used.get(neighbor.val));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CloneGraph sln = new CloneGraph();
        Node n1 = sln.new Node(1);
        Node n2 = sln.new Node(2);
        Node n3 = sln.new Node(3);
        Node n4 = sln.new Node(4);

        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n3);

        Node copy = sln.cloneGraph(n1);
        printGraph(copy, new HashMap<>());
    }

    private static void printGraph(Node origin, Map<Integer, Node> used) {

        if (!used.containsKey(origin.val)) {
            System.out.println(origin.val);

            used.put(origin.val, origin);
            for (int i = 0; i < origin.neighbors.size(); i++) {
                printGraph(origin.neighbors.get(i), used);
            }
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
