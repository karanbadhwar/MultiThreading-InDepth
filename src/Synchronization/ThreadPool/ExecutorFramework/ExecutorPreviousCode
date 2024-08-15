package Synchronization.ThreadPool.ExecutorFramework;

//We Use Executor Framework to Operate upon Thread Pool.
// There are Three Core Interfaces -> Executor, ExecutorService and ScheduledExecutorService

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        Thread[] threads = new Thread[9];
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i < 10; i++) {
            int finalI = i;
//            executor.execute(() -> { //Execute methods does not have Shutdown Method, as it is from Executor Interface.
//                long result = factorial(finalI);
//                System.out.println(result);
//            });

            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });



        }
        executor.shutdown();

        try {
            // Same as Join() but with some conditions
//            executor.awaitTermination(10, TimeUnit.SECONDS); // Returns Boolean

            //But if needed unlimited Time until all methods have been executed...
            while(!executor.awaitTermination(1, TimeUnit.SECONDS))
            {
                System.out.println("Waiting...");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime));
    }

    public static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        long result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}
