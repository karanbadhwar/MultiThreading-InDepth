package Synchronization.ThreadPool.ExecutorFramework;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        Future<Integer> future = executorService.submit(() -> {
            try
            {
                Thread.sleep(2000);
            } catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println("Hello");
            return 42;
        });
//        try {
//            Integer i = future.get(1, TimeUnit.SECONDS);
//            System.out.println(future.isDone());
//            System.out.println(i);
//        } catch (Exception e) {
//            System.out.println("Exception Occured: "+e);
//        }

        try{
            Thread.sleep(1000);
        } catch(Exception e)
        {
            System.out.println(e);
        }

        future.cancel(false); // Boolean parameter states to cancel the task, even if the task is running.
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
        executorService.shutdown();
    }
}
