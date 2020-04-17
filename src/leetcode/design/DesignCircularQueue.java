// Design your implementation of the circular queue. The circular queue is a linear data structure 
// in which the operations are performed based on FIFO (First In First Out) principle and the last 
// position is connected back to the first position to make a circle. It is also called "Ring Buffer".
// See: https://leetcode.com/problems/design-circular-queue/

package leetcode.design;

import java.util.Arrays;

public class DesignCircularQueue {
    /**
     * Array implementation.
     */
    class MyCircularQueue {
        private int[] q;
        int rear = -1;
        int front = 0;
        int size;
        int len = 0;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            q = new int[k];
            size = k;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is
         * successful.
         */
        public boolean enQueue(int value) {
            if (!isFull()) {
                q[++rear % size] = value;
                len++;
                return true;
            }

            return false;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is
         * successful.
         */
        public boolean deQueue() {
            if (isEmpty())
                return false;
            front = (front + 1) % size;
            len--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (!isEmpty())
                return q[front];
            return -1;
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (!isEmpty())
                return q[rear % size];
            return -1;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return len == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return len == size;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue q = new DesignCircularQueue().new MyCircularQueue(3);
        q.enQueue(1); // return true

        System.out.println(Arrays.toString(q.q));

        q.enQueue(2); // return true
        q.enQueue(3); // return true

        System.out.println(Arrays.toString(q.q));

        q.enQueue(4); // return false, the queue is full
        q.Rear(); // return 3
        q.isFull(); // return true

        System.out.println(Arrays.toString(q.q));

        q.deQueue(); // return true
        q.enQueue(4); // return true

        System.out.println(Arrays.toString(q.q));

        q.Rear(); // return 4
    }

}
