// Implement the following operations of a queue using stacks.
//   - push(x) -- Push element x to the back of queue.
//   - pop() -- Removes the element from in front of queue.
//   - peek() -- Get the front element.
//   - empty() -- Return whether the queue is empty.
// See: https://leetcode.com/problems/implement-queue-using-stacks/
// See: https://leetcode.com/problems/implement-queue-using-stacks/discuss/583715/Java-O(1)-time-for-peek()

package leetcode.design;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        private int topElement;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (s1.isEmpty()) topElement = x;
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int size = s1.size();
            for (int i = 0; i < size - 1; i++)
                s2.push(s1.pop());

            int head = s1.pop();
            
            if (!s2.isEmpty()) topElement = s2.peek();
            for (int i = 0; i < size - 1; i++)
                s1.push(s2.pop());

            return head;
        }

        /** Get the front element. */
        public int peek() {
            return topElement;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new ImplementQueueUsingStacks().new MyQueue();
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.peek());
    }

}
