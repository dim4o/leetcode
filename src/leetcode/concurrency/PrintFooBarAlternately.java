// Suppose you are given the following code:
//
// class FooBar {
//   public void foo() {
//     for (int i = 0; i < n; i++) {
//       print("foo");
//     }
//   }
//
//   public void bar() {
//     for (int i = 0; i < n; i++) {
//       print("bar");
//     }
//   }
// }
// The same instance of FooBar will be passed to two different threads. 
// Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
// See: https://leetcode.com/problems/print-foobar-alternately/

package leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFooBarAlternately {
    /**
     * Solution 4: Semaphores - simple and clean, without verbose wait/notify/signal mechanism and while loops.
     */
    class FooBar {
        private int n;
        private Semaphore semFoo = new Semaphore(1);
        private Semaphore semBar = new Semaphore(0);
        
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                semFoo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                semBar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // because the initial value of the "semBar" is 0 the tread will wait here until "semBar.release();"
                semBar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                semFoo.release();
            }
        }
    }

    /**
     * Solution 3: The good old wait/notify
     */
    class FooBar3 {
        private int n;
        private volatile boolean foo = true;
        private Object sync = new Object();

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (sync) {
                    while (!foo)
                        sync.wait();
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    foo = false;
                    sync.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (sync) {
                    while (foo)
                        sync.wait();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    foo = true;
                    sync.notifyAll();
                }
            }
        }
    }

    /**
     * Solution 2: Lock/await/signalAll
     */
    class FooBar2 {
        private int n;
        private ReentrantLock lock = new ReentrantLock();
        private Condition fooCond = lock.newCondition();
        private volatile boolean foo = true;

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    while (!foo)
                        fooCond.await();
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();

                    foo = false;
                    fooCond.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    while (foo)
                        fooCond.await();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();

                    foo = true;
                    fooCond.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        /**
         * Solution 1: Simple boolean condition
         */
        class FooBar1 {
            private int n;
            private volatile boolean foo = true;

            public FooBar1(int n) {
                this.n = n;
            }

            public void foo(Runnable printFoo) throws InterruptedException {
                for (int i = 0; i < n; i++) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    while (!foo) {
                    }
                    printFoo.run();
                    foo = false;
                }
            }

            public void bar(Runnable printBar) throws InterruptedException {
                for (int i = 0; i < n; i++) {
                    while (foo) {
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    foo = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        FooBar foobar = new PrintFooBarAlternately().new FooBar(2);

        Thread th1 = new Thread(() -> {
            try {
                foobar.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("foo");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread th2 = new Thread(() -> {
            try {
                foobar.bar(new Runnable() {

                    @Override
                    public void run() {
                        System.out.print("bar");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        th1.start();
        th2.start();
    }

}
