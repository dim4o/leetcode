// A linked list is given such that each node contains an additional 
// random pointer which could point to any node in the list or null.
// Return a deep copy of the list.
// See: https://leetcode.com/problems/copy-list-with-random-pointer/

package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(-1);
        Node result = newHead;
        Node originHead = head;
        
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            newHead.next = new Node(head.val);
            newHead = newHead.next;
            map.put(head, newHead);
            head = head.next;
        }
        
        Node start = result.next;
        while (start != null) {
            start.random = map.get(originHead.random);
            start = start.next;
            originHead = originHead.next;
        }
        
        return result.next;
    }

    public static void main(String[] args) {
        
    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
