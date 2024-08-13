package ThreadClassMethods;

public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield(); // Hint to the OS scheduler, to give chance to other Thread first!! HINT
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}

/*
    Methods to Cover :-
        1 - start()
        2 - run()
        3 - sleep()
        4 - join()
        5 - setPriority()
        6 - interrupt()
        7 - yield()
        8 -setDaemon

 */