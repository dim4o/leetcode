// Implement the following operations of a stack using queues.
//   - push(x) -- Push element x onto stack.
//   - pop() -- Removes the element on top of the stack.
//   - top() -- Get the top element.
//   - empty() -- Return whether the stack is empty.
// See: https://leetcode.com/problems/implement-stack-using-queues/

package leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    class MyStack {
        private Queue<Integer> q1 = new LinkedList<Integer>();
        private Queue<Integer> q2 = new LinkedList<Integer>();
        private int top = 0;

        /** Initialize your data structure here. */
        public MyStack() {
            
        }
        
        /** Push element x onto stack. */
        public void push(int x) {
            top = x;
            q1.add(x);
        }
        
        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++)
                q2.add(q1.poll());
            int res = q1.poll();
            for (int i = 0; i < size - 1; i++) {
                if (i == size - 2) top = q2.peek();
                q1.add(q2.poll());
            }
            return res;
        }
        
        /** Get the top element. */
        public int top() {
            return top;
        }
        
        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    
    public static void main(String[] args) {
        MyStack sln = new ImplementStackUsingQueues().new MyStack();
        sln.push(1);
        sln.push(2);
        sln.push(3);
        
        System.out.println(sln.top());
        System.out.println(sln.pop());
        System.out.println(sln.pop());
    }

}
