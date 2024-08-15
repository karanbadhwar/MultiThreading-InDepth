package Synchronization.ThreadPool.ExecutorFramework;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class scheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService SE = Executors.newScheduledThreadPool(1);

//        SE.schedule(() -> System.out.println("Task Executed after 5 seconds delay !"), 5, TimeUnit.SECONDS);

        SE.scheduleAtFixedRate(() -> System.out.println("Task Executed after every 5 seconds delay !"), 5, 5, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = SE.scheduleWithFixedDelay(() -> System.out.println("Task Executed after every 5 seconds delay, but first will run after more 5 seconds !"), 5, 5, TimeUnit.SECONDS);

        SE.schedule(() -> {
            System.out.println("Initiating Shutdown...");
            SE.shutdown();
        }, 20, TimeUnit.SECONDS);
//        SE.shutdown();
    }
}
