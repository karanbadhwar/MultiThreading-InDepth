package Synchronization.ThreadPool.ExecutorFramework;

import java.util.concurrent.*;

//EXECUTORS SERVICES CAN RUN THREAD WITH THREAD CLASS INSTANCE/ RUNNABLE/ CALLABLE!! While Manual Threads cannot run with Callable.

public class CountDownLatchWithExecutors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //We Use CountDownLatch is used, when we want to make 1 or more than 1 Threads WAIT!!.
        //In the Constructor, we give the no. of Operations we want to conduct.
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await(); // This will make the Main Method wait here, until the lock/latch is open.
        System.out.println("All Dependent Services finished. Starting main service...");
        executorService.shutdown();

        //Other way to make the Main Thread Wait using future.get() method.
//        Future<String> future1 = executorService.submit(new DependentService());
//        Future<String> future2 = executorService.submit(new DependentService());
//        Future<String> future3 = executorService.submit(new DependentService());
//
        //To make the Main Thread wait, we are doing this
//        future1.get();
//        future2.get();
//        future3.get();
//
//        System.out.println("All Dependent Services finished. Starting main service...");
//        executorService.shutdown();
    }
}

class DependentService implements Callable<String>{

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public String call() throws Exception {
        try
        {
            System.out.println(Thread.currentThread().getName() + " service started");
            Thread.sleep(2000);
        } finally {
            latch.countDown();//This Reduces the Latch's Number by One.
        }

        return "ok";
    }
}
