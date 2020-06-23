// Suppose we have a class:
// public class Foo {
//   public void first() { print("first"); }
//   public void second() { print("second"); }
//   public void third() { print("third"); }
// }
// The same instance of Foo will be passed to three different threads. Thread A will call first(), 
// thread B will call second(), and thread C will call third(). Design a mechanism and modify 
// the program to ensure that second() is executed after first(), and third() is executed after second().
// See: https://leetcode.com/problems/print-in-order/

package leetcode.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PrintInOrder {
    /**
     * Solution 3: Semaphores.
     * This is an interesting solution because is not intuitive if you think about semaphores in terms of "permits".
     * Actually semSecond.release() will increase the number of permits from 0 to 1.
     * The constructor rather means "initial number of permits".
     */
    class Foo {
        private Semaphore semSecond = new Semaphore(0);
        private Semaphore semThird = new Semaphore(0);
        public Foo() {
        }
        
        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semSecond.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semSecond.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semThird.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semThird.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
    
    /**
     * Solution 2: Simple solution with CountDownLatch
     */
    class Foo2 {
        private CountDownLatch latchForSecond = new CountDownLatch(1);
        private CountDownLatch latchForThird = new CountDownLatch(1);

        public Foo2() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            latchForSecond.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            latchForSecond.await();
            printSecond.run();
            latchForThird.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            latchForThird.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

            // No need to reset the latch because different instances are passed for each
            // test case.
            // latchForSecond = new CountDownLatch(1);
            // latchForSecond = new CountDownLatch(1);
        }
    }

    /**
     * Solution 1: Simple solution with booleans
     */
    class Foo1 {
        private volatile boolean first = false;
        private volatile boolean second = false;

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!first) {
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second = true;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!second) {
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            // first = false;
            // second = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new PrintInOrder().new Foo();
        class PrintFirst implements Runnable {
            @Override public void run() {
                System.out.println("first");
            }
        }
        class PrintSecond implements Runnable {
            @Override public void run() {
                System.out.println("second");
            }
        }
        class PrintThird implements Runnable {
            @Override public void run() {
                System.out.println("third");
            }
        }

        Thread th1 = new Thread(() -> {
            try {
                foo.first(new PrintFirst());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread th2 = new Thread(() -> {
            try {
                foo.second(new PrintSecond());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread th3 = new Thread(() -> {
            try {
                foo.third(new PrintThird());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        th3.start();
        Thread.sleep(300);
        th1.start();
        Thread.sleep(100);
        th2.start();

        Thread.currentThread().join();
    }
}
