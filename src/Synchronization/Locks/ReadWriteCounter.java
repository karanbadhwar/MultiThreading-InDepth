package Synchronization.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int counter = 0;

    //As Synchronized, do not differentiate b/w Read and Write, with Manual Lock we can do that.
    // Read can run concurrently unless write operation is going on.
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment()
    {
        writeLock.lock();
        try
        {

            counter++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            writeLock.unlock();
        }
    }

    public int getCount()
    {
        //Multiple Thread can acquire Read lock, only if Write Lock is not acquired by some other Thread
        readLock.lock();
        try
        {
            return this.counter;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: "+ counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            }
        };

        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        writeThread.join();
        readThread1.join();
        readThread2.join();

        System.out.println("Final count:" + counter.getCount());
    }
}
