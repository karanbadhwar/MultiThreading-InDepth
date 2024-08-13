package Synchronization.Locks;

//Two types of Locks
// 1 - Intrinsic -> These are built into every object in java. We don't see them, but they are there. When we use Synchronized keyword, you're using these automatic locks.
// 2 - Explicit -> These are more advanced locks you can control yourself using the Lock Class from java.util.concurrent.locks.
// You explicitly say when to lock and when to unlock, giving you more control over how and when people can modify.


import ThreadClassMethods.MyThread;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        t1.start();
        t2.start();
    }

}
