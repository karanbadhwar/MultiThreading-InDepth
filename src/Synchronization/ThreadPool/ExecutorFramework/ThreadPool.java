package Synchronization.ThreadPool.ExecutorFramework;

//We Use Executor Framework to Operate upon Thread Pool.
// There are Three Core Interfaces -> Executor, ExecutorService and ScheduledExecutorService

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args){
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //In the Submit, it accepts Runnable or Callable, over here eCallable is being accepted, as Callable returns a Value.
//        Future<?> future = executorService.submit(() -> 42);

//        Callable<Integer> callable = () -> 42;

//        System.out.println(future.get()); //Get method will wait unt il the method above executes
//        System.out.println(future.isDone());
//        executorService.shutdown();

        //Third Way of calling submit Method on executorService
//        Future<String> future = executorService.submit(() -> System.out.println("Hello"), "Success");
//        System.out.println(future.get());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            Thread.sleep(1000);
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            Thread.sleep(1000);
            return 2;
        };;
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            Thread.sleep(1000);
            return 3;
        };;

        List<Callable<Integer>> list = Arrays.asList(callable1,callable2,callable3);

        //invokeAll() locks the further Tasks of the Calling Thread, until all the tasks have been executed.
//        List<Future<Integer>> futures = executorService.invokeAll(list);

        //This will only invoke the methods until the Given TIme.
        List<Future<Integer>> futures = null;
        try {
            futures = executorService.invokeAll(list,1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Future<Integer> f: futures)
        {
            try {
                System.out.println(f.get());
            } catch (Exception e) {

            }
        }
        executorService.shutdown();
        System.out.println("End of Main Thread");

    }
}
