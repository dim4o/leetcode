// Design your implementation of the linked list. You can choose to use the singly linked list or 
// the doubly linked list. A node in a singly linked list should have two attributes: 
// val and next. val is the value of the current node, and next is a pointer/reference to the next node. 
// If you want to use the doubly linked list, you will need one more attribute prev to indicate 
// the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
// See: https://leetcode.com/problems/design-linked-list/

package leetcode.design;

public class DesignLinkedList {
    class MyLinkedList {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }

        private ListNode nullHead;

        public MyLinkedList() {
            nullHead = new ListNode(-1);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is
         * invalid, return -1.
         */
        public int get(int index) {
            ListNode head = nullHead;
            for (int i = 0; i < index; i++)
                head = head.next;
            if (head.next == null)
                return -1;

            return head.next.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After
         * the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode tmp = nullHead.next;
            nullHead.next = new ListNode(val);
            nullHead.next.next = tmp;
        }

        // TODO: The current time complexity for this operation is O(n).
        // Implement this operation in O(1) time (for example you can keep the tail).

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode head = nullHead;
            while (head != null && head.next != null)
                head = head.next;
            head.next = new ListNode(val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index
         * equals to the length of linked list, the node will be appended to the end of
         * linked list. If index is greater than the length, the node will not be
         * inserted.
         */
        public void addAtIndex(int index, int val) {
            ListNode head = nullHead;
            for (int i = 0; i < index; i++)
                head = head.next;

            ListNode tmp = head.next;
            head.next = new ListNode(val);
            head.next.next = tmp;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            ListNode head = nullHead;
            for (int i = 0; i < index; i++)
                if (head.next != null)
                    head = head.next;

            if (head != null && head.next != null)
                head.next = head.next.next;
        }

//        public void print() {
//            String res = "";
//            ListNode head = nullHead.next;
//            while (head != null) {
//                res += head.val;
//                res += "->";
//                head = head.next;
//            }
//            System.out.println(res);
//        }
    }

    public static void main(String[] args) {
        MyLinkedList l = new DesignLinkedList().new MyLinkedList();
        l.addAtHead(1);
        l.addAtTail(3);
        l.addAtIndex(1, 2);
    }

}
