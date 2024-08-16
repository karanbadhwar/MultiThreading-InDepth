package Synchronization.ThreadPool.ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchWithThread {
    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        for (int i = 0; i < numberOfServices; i++) {

            new Thread(new DependentServiceWithThread(latch)).start();
        }
//        latch.await();
        //We can give custom Time as well.
        latch.await(1, TimeUnit.SECONDS);
        System.out.println("End of Main");
    }
}

class DependentServiceWithThread implements Runnable {

    private final CountDownLatch latch;

    public DependentServiceWithThread(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        try
        {
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " service started");
        } catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }finally {
            latch.countDown();//This Reduces the Latch's Number by One.
        }
    }
}

