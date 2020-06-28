// Suppose you are given the following code:
// class ZeroEvenOdd {
//   public ZeroEvenOdd(int n) { ... }      // constructor
//   public void zero(printNumber) { ... }  // only output 0's
//   public void even(printNumber) { ... }  // only output even numbers
//   public void odd(printNumber) { ... }   // only output odd numbers
// }
// The same instance of ZeroEvenOdd will be passed to three different threads:
//
// Thread A will call zero() which should only output 0's.
// Thread B will call even() which should only ouput even numbers.
// Thread C will call odd() which should only output odd numbers.
// Each of the threads is given a printNumber method to output an integer. 
// Modify the given program to output the series 010203040506... where the length of the series must be 2n.
// See: https://leetcode.com/problems/print-zero-even-odd/
// See: https://leetcode.com/problems/print-zero-even-odd/discuss/636782/Java-Easy-ans-Concise-Solution-with-Semaphores

package leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {
    // TODO: Solution with locks and conditions
    // TODO: Solution with wait notify mechanism
    /**
     * Solution 1: Semaphores
     */
    class ZeroEvenOdd {
        private int n;
        
        private Semaphore zero = new Semaphore(1);
        private Semaphore even = new Semaphore(0);
        private Semaphore odd = new Semaphore(0);
        
        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zero.acquire();
                printNumber.accept(0);                
                if (i % 2 != 0)
                    even.release();
                else 
                    odd.release();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i+=2) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i+=2) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }
    
    
}
