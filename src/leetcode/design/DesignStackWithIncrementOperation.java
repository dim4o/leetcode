// Design a stack which supports the following operations.
// Implement the CustomStack class:
//   - CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number 
//     of elements in the stack or do nothing if the stack reached the maxSize.
//   - void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
//   - int pop() Pops and returns the top of stack or -1 if the stack is empty.
//   - void inc(int k, int val) Increments the bottom k elements of the stack by val. 
//     If there are less than k elements in the stack, just increment all the elements in the stack.
// See: https://leetcode.com/problems/design-a-stack-with-increment-operation/

package leetcode.design;

public class DesignStackWithIncrementOperation {
    class CustomStack {
        int[] arr;
        int top = -1;
        
        public CustomStack(int maxSize) {
            arr = new int[maxSize];
        }

        public void push(int x) {
            if (top < arr.length - 1)
                arr[++top] = x;
        }

        public int pop() {
            if (top  > -1) return arr[top--];
            return -1;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(arr.length, k); i++)
                arr[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new DesignStackWithIncrementOperation().new CustomStack(3);
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        customStack.pop();                            // return -1 --> Stack is empty return -1.
    }

}
