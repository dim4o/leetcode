// Design your implementation of the circular double-ended queue (deque).
// Your implementation should support following operations:
//   - MyCircularDeque(k): Constructor, set the size of the deque to be k.
//   - insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
//   - insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
//   - deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
//   - deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
//   - getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
//   - getRear(): Gets the last item from Deque. If the deque is empty, return -1.
//   - isEmpty(): Checks whether Deque is empty or not. 
//   - isFull(): Checks whether Deque is full or not.
// See: https://leetcode.com/problems/design-circular-deque/

package leetcode.design;

public class DesignCircularDeque {
    // TODO: Use `mod` operator for concise solution
    class MyCircularDeque {
        int rear = 0;
        int front = -1;
        int[] arr;
        int len = 0;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            arr = new int[k];
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertFront(int value) {
            if (!isFull()) {
                if (front == -1) {
                    front = 0;
                    rear = 0;
                } else if (front == 0) {
                    front = arr.length - 1;
                } else --front;
                arr[front] = value;
                len++;
                return true;
            }
            return false;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertLast(int value) {
            if (!isFull()) {
                if (front == -1) {
                    front = 0;
                    rear = 0;
                } else if (rear == arr.length - 1) {
                    rear = 0;
                } else ++rear;
                arr[rear] = value;
                len++;
                return true;
            }

            return false;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteFront() {
            if (!isEmpty()) {
                if (len == 1) {
                    front = -1;
                    rear = -1;
                } else if (front == arr.length - 1) {
                    front = 0;
                } else ++front;
                len--;
                return true;
            }
            return false;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteLast() {
            if (!isEmpty()) {
                if (len == 1) {
                    front = -1;
                    rear = -1;
                } else if (rear == 0) {
                    rear = arr.length - 1;
                } else --rear;
                len--;
                return true;
            }
            return false;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty())
                return -1;
            return arr[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty())
                return -1;
            return arr[rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return len == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return len == arr.length;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque q = new DesignCircularDeque().new MyCircularDeque(3);

        System.out.println(q.insertFront(7));
        System.out.println(q.deleteLast());
        System.out.println(q.getFront());
        System.out.println(q.insertLast(5));
        System.out.println(q.insertFront(0));
        System.out.println(q.getFront());
        System.out.println(q.getRear());
    }
}
