package Synchronization.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {

    //Fairness does not mean, the way we called it. It means the First thread reached to access the lock will get it, Scheduler will be fair.
    private final Lock lock = new ReentrantLock(true);

    public void accessResource()
    {
        lock.lock();
        try
        {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);
        } catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairnessLockExample example = new FairnessLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 =new Thread(task, "Thread 1");
        Thread thread2 =new Thread(task, "Thread 2");
        Thread thread3 =new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
