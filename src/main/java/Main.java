public class Main extends Thread{

    public static void main(String[] args) {
        System.out.println("ioio");

        System.out.println("main: "+Thread.currentThread().getName() );

        Runnable task = new DefaultRunnable();
        Thread t1 = new Thread(task);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a new thread t2! My name is " + Thread.currentThread().getName());
            }
        });

        Thread t3 = new Main();

        Thread t4 = new Thread(() ->
                System.out.println("I'm a new thread t4! My name is " + Thread.currentThread().getName()));

        Thread t5 = new Thread(Main::execute);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    @Override
    public void run() {
        System.out.println("I'm a new thread t3! My name is " + Thread.currentThread().getName());
    }

    public static void execute() {
        System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName());
    }
}


class DefaultRunnable implements Runnable{

    private String externalString;

    public DefaultRunnable() {
    }

    public DefaultRunnable(String externalString) {
        this.externalString = externalString;
    }

    @Override
    public void run() {
        System.out.println("I'm a new thread t1! My name is " + Thread.currentThread().getName());
    }
}
