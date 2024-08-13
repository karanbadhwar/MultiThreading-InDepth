package BasicStart;

public class Hello {
    public static void main(String[] args) {
        World world = new World();
        //This works, only when a class has extended Thread Class
//        world.start();

        //To start a Thread created using implementing Runnable interface
        Thread t1 = new Thread(world);
        for (int i = 0; i < 10000; i++) {
            System.out.println("BasicStart.Hello");
        }
    }
}
