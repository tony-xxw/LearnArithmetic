package thread;

import sun.jvm.hotspot.types.JShortField;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private static final ReentrantReadWriteLock reentrantRead = new ReentrantReadWriteLock(false);
    private static final ReentrantReadWriteLock.ReadLock readLock = reentrantRead.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = reentrantRead.writeLock();


    public static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁,正在读取");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放锁");
            readLock.unlock();
        }
    }

    public static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁,正在写入");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {
        new Thread(ReadWriteLockDemo::write).start();
        new Thread(ReadWriteLockDemo::write).start();
        new Thread(ReadWriteLockDemo::read).start();
        new Thread(ReadWriteLockDemo::read).start();

    }
}
