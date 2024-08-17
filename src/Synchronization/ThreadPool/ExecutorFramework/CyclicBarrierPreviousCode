package Synchronization.ThreadPool.ExecutorFramework;

import java.util.concurrent.*;

public class CyclicBarrierExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //We Use CountDownLatch is used, when we want to make 1 or more than 1 Threads WAIT!!.
        //In the Constructor, we give the no. of Operations we want to conduct.
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
        executorService.submit(new DependentServiceWithCyclicBarrier(barrier));
        executorService.submit(new DependentServiceWithCyclicBarrier(barrier));
        executorService.submit(new DependentServiceWithCyclicBarrier(barrier));

        //This does not block the Main Thread!!
        System.out.println("All Dependent Services finished. Starting main service...");
//        System.out.println(barrier.getNumberWaiting());
        executorService.shutdown();

    }
}

class DependentServiceWithCyclicBarrier implements Callable<String> {

    private final CyclicBarrier barrier;

    public DependentServiceWithCyclicBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }


    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " is waiting ath the barrier ");
        barrier.await(); // This makes sure every worker Thread has arrived at this step, as Object of barrier is being passed from the top. So it keeps Track.
        return "ok";
    }
}
