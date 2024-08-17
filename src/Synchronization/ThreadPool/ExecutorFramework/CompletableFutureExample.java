package Synchronization.ThreadPool.ExecutorFramework;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //This is a Daemon Thread by Default!!
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println("Worker Thread");
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//            return "Ok";
////            return null;
//        });

//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println("Worker Thread");
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//            return "Ok";
////            return null;
//        });

//        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(future1, future2);
//
//        resultFuture.join(); //Same as Thread.join();
//
//        System.out.println("ENd of Main");


//        String s = null;

        //This is not like .get() which makes the caller Thread wait.
//        s = completableFuture.getNow("NullIfNoValueReturned");
//        try {
//             s = completableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(s);
//        System.out.println("Main Thread");


//        try {
//            String f1 = CompletableFuture.supplyAsync(() -> {
//                try {
//                    Thread.sleep(5000);
//                    System.out.println("Worker Thread");
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
//                return "Ok";
//    //            return null;
//            }).get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }

//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println("Worker Thread");
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//            return "Ok";
////            return null;
//        }).thenApply((x) -> x + x);

        //Using with Thread Pool

        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker Thread");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            return "Ok";
        },executor);

//        System.out.println(future1.get());
        executor.shutdown();
        System.out.println("End of Main");
    }
}
//NOTE
/*
    By default, CompletableFuture tasks often run on Daemon Threads due to the use of ForkJoinPool.commonPool.
    We can control the thread type by providing a custom executor service.
    The CompletableFuture task itself doesn't dictate whether it's a daemon thread or user thread
 */
