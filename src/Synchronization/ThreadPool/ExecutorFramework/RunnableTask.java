package Synchronization.ThreadPool.ExecutorFramework;

public class RunnableTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
