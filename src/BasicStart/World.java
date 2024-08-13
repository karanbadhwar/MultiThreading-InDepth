package BasicStart;
//To create a Thread Either extends Thread Class or Implements Runnable Interface
//public class BasicStart.World extends Thread -> example

public class World implements Runnable{
    @Override
    public void run()
    {
        for (int i = 0; i < 10000; i++) {
            System.out.println("BasicStart.World");
        }
    }
}
