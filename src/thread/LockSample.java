package thread;

import sun.rmi.runtime.Log;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample {
//    public void test() {
//        synchronized (this) {
//            System.out.println("xxw");
//        }
//    }

    public synchronized void test() {
        System.out.println("xxw");
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantLock reentrantLock1 = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LockTest(reentrantLock, reentrantLock1);
                }
            }).start();
        }

    }

    public static void LockTest(Lock lock1, Lock lock2) {
        while (true) {
            if (lock1.tryLock()) {
                try {
                    if (lock2.tryLock()) {
                        try {
                            System.out.println("获取到两把锁");
                            return;
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                }
            } else {
                System.out.println("等待");
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
