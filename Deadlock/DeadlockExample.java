package Deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " locked resource 1");
                        Thread.sleep(100);
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " locked resource 2");
                                break;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " locked resource 2");
                        Thread.sleep(100);
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " locked resource 1");
                                break;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}

