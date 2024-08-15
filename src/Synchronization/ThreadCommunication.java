package Synchronization;

/*
    There are ways to Communicate between threads, THESE METHODS ONLY WORK WITHIN SYNCHRONIZED METHODS!!
    1 - wait();
    2 - notify();
    3 - notifyAll();
 */

class SharedResources
{
    private int data;

    private boolean hasData;

    public synchronized void produce(int value)
    {
        while(hasData)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = value;
        hasData = true;
        System.out.println("Produced: "+value);
        notify();
    }

    public synchronized void consume()
    {
        while(!hasData)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: "+this.data);
        notify();
    }
}

class Producer implements Runnable
{
    private SharedResources resource;

    public Producer(SharedResources resource)
    {
        this.resource = resource;
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            resource.produce(i);

        }
    }
}

class Consumer implements Runnable
{
    private SharedResources resource;

    public Consumer(SharedResources resource)
    {
        this.resource = resource;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++) {
           resource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResources resource = new SharedResources();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
