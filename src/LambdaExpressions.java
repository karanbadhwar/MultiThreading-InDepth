public class LambdaExpressions {
    public static void main(String[] args) {
        //One way to define Thread Runnable Part with Anonymous class
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        };

        //Other way to define a Thread runnable Part with Lambda Expression
//        Runnable runnable = () -> System.out.println("Hello");

        //Third way to define a Thread in more precise way with Lambda Expression
        Thread t1 = new Thread( () -> System.out.println("Hello"));
    }
}
