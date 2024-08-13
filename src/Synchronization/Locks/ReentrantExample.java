package Synchronization.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerMethod()
    {
        lock.lock();
        try
        {
            System.out.println("Outer Method");
            innerMethod();
        } finally{
            lock.unlock();
        }
    }

    public void innerMethod()
    {
        //It is the same lock that we did in the upper OuterMethod(), as name suggests reentrant,
        // meaning we can re-enter again take Outer Method as House key and Inner Method as Room Key,
        // Once we enter from outside , we can still have lock in the Inner one and same corresponding to Unlock Method goes for.
        lock.lock();
        try
        {
            System.out.println("Inner Method");
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }

}
