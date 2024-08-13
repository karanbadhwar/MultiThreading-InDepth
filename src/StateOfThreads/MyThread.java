package StateOfThreads;

//This is for demonstrating States of Thread

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(2000); //This makes the state Timed/Waiting/Blocked
            System.out.println("T1 is Back from Sleep");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

//        Thread.currentThread()// This, when called on any method gets the Current Thread Info.
//        System.out.println("Current Thread:" +Thread.currentThread().getState());

        MyThread t1 = new MyThread(); // NEW -> state
        System.out.println(t1.getState());

        t1.start();//RUNNABLE -> state
        System.out.println(t1.getState());

        //Current Thread on sleep
        Thread.sleep(100);

        System.out.println(t1.getState()); //Timed/Waiting/Blocked -> state, as the Thread is on sleep, if wait for more than 2s then it will print it back again

        t1.join(); //When we invoke the join() method on a thread, the calling thread goes into a waiting state. It remains in a waiting state until the referenced thread terminates.
        System.out.println(t1.getState());
        System.out.println("End of Main Thread");
    }
}
