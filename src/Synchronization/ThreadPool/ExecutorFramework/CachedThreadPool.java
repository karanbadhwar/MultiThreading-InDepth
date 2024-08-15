package Synchronization.ThreadPool.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
//        Executors.newSingleThreadExecutor();
//        Executors.newScheduledThreadPool(1);
//        Executors.newFixedThreadPool(2);

        //CachedThreadPool Dynamically keeps on adjusting The size of the pool,
        //if a Thread is unused, will terminate after 60 seconds of non-usage.
        //If more Threads are needed, it will create more Threads.
        //It is used when the Load is Variable and the load is for Short Usage(Short Lived).
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
