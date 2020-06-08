// You have a queue of integers, you need to retrieve the first unique integer in the queue.
// Implement the FirstUnique class:
//   - FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
//   - int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
//   - void add(int value) insert value to the queue.
// See: https://leetcode.com/problems/first-unique-number/

package leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FirstUniqueNumber {

    class FirstUnique {
        private final Map<Integer, Integer> map = new HashMap<>();
        private final LinkedList<Integer> q = new LinkedList<>();

        public FirstUnique(int[] nums) {
            for (int num : nums)
                add(num);
        }

        public int showFirstUnique() {
            while (!q.isEmpty() && map.get(q.peekFirst()) > 1)
                q.removeFirst();
            if (q.isEmpty())
                return -1;

            return q.getFirst();
        }

        public void add(int value) {
            map.put(value, map.getOrDefault(value, 0) + 1);
            if (map.get(value) == 1)
                q.add(value);
        }
    }

    class FirstUnique_var {
        class Node {
            int val;
            Node prev;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        Node head = new Node(-1);
        Node tail = new Node(-1);
        private final Map<Integer, Node> map = new HashMap<>();

        public FirstUnique_var(int[] nums) {
            head.next = tail;
            tail.prev = head;
            for (int num : nums)
                add(num);
        }

        public int showFirstUnique() {
            if (head.next == null)
                return -1;
            return head.next.val;
        }

        public void add(int value) {
            if (!map.containsKey(value)) {
                // append a new node to the list
                Node newNode = new Node(value);
                Node prev = tail.prev;
                tail.prev = newNode;
                newNode.next = tail;
                newNode.prev = prev;
                prev.next = newNode;
                
                map.put(value, newNode);
            } else if (map.get(value) != null) {
                // remove a node from the list
                Node nodeToRemove = map.remove(value);
                nodeToRemove.prev.next = nodeToRemove.next;
                nodeToRemove.next.prev = nodeToRemove.prev;
                map.put(value, null);
            }
        }
    }

    public static void main(String[] args) {
        FirstUnique fu = new FirstUniqueNumber().new FirstUnique(new int[] { 2, 3, 5 });

        System.out.println(fu.showFirstUnique());
        fu.add(5);
        System.out.println(fu.showFirstUnique());
        fu.add(2);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());

        System.out.println();

        fu = new FirstUniqueNumber().new FirstUnique(new int[] { 7, 7, 7, 7, 7, 7, 7 });
        System.out.println(fu.showFirstUnique());
        fu.add(7);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());
        fu.add(7);
        System.out.println(fu.showFirstUnique());
        fu.add(17);
        System.out.println(fu.showFirstUnique());

    }

}
