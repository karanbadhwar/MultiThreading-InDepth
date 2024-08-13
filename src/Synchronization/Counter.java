package Synchronization;

public class Counter {
    private int count = 0;

    //This makes the whole Method Synchronized
//    public synchronized void increment()
//    {
//        this.count++;
//    }

    //The part where shared resources/data is being accessed and modified is called critical section. Ex - same synchronized block in increment block
    //With synchronized keyword, we made sure we enabled Mutual Exclusion, meaning we restricted multiple threads to use shared resources at the same time, but use them one after another
    public void increment()
    {
        //This just creates this block synchronized not the whole method
        synchronized (this)
        {
            count++;
        }
    }

    public int getCount()
    {
        return this.count;
    }

}

