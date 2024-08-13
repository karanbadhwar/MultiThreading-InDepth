package ThreadClassMethods;

public class MyThread extends Thread{

    @Override
    public void run() {
        int i = 0;
        while(i < 10000)
        {
            System.out.println("Hello World");
            i++;
        }
    }

    //Daemon Threads are that runs in the Background, example Garbage Collector, and JVM do not wait for these Threads to finish
    public static void main(String[] args) throws InterruptedException {
        //The Threads that created the Thread that runs the business logic and that do the heavy lifting is called User Thread.
        MyThread t1 = new MyThread();
        t1.setDaemon(true); // This creates the User Thread to Daemon Thread, now Once the Main User Thread is finish, JVM will shut off the DaeMon Thread.
        t1.start();
        System.out.println("End of Main Thread");
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