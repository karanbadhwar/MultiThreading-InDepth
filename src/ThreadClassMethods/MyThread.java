package ThreadClassMethods;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        t1.join();
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

 */