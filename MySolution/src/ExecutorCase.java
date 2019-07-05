import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorCase {
    private static Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            // System.out.println(" i : " + i);
            // Thread t = new Thread(() ->
            // System.out.println(Thread.currentThread().getName()), "my thread " + i);
            // t.start();
            // System.out.println(" t : " + t.getName());
            // executor.execute(t);
            executor.execute(new Task());
        }
    }

    SecurityManager s = System.getSecurityManager();

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}