package thread;


import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadLockJumpQueue {
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    private static final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();



    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }





    public static void main(String[] args) {
        new Thread(ReadLockJumpQueue::read, "Thead-2").start();
        new Thread(ReadLockJumpQueue::read, "Thead-4").start();
        new Thread(ReadLockJumpQueue::write, "Thead-3").start();
        new Thread(ReadLockJumpQueue::read, "Thead-5").start();
    }

}
