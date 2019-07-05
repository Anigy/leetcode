import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAwaitSignal {

    private Lock lock = new ReentrantLock();
    private Condition ca = lock.newCondition();
    private Condition cb = lock.newCondition();
    private Condition cc = lock.newCondition();

    private void printStr(String str) throws Exception {
        lock.lock();
        String currentThreadName = Thread.currentThread().getName();
        if (currentThreadName == "ta") {
            while (str != "aa") {
                ca.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(str);
            }
            cb.signal();
        } else if (currentThreadName == "tb") {
            while (str != "bb") {
                cb.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(str);
            }
            cc.signal();
        } else if (currentThreadName == "tc") {
            while (str != "cc") {
                cc.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(str);
            }
            ca.signal();
        }
        lock.unlock();
    }

    public static void main(String[] args) throws Exception {

        LockAwaitSignal las = new LockAwaitSignal();

        Thread ta = new Thread(() -> {
            try {
                las.printStr("aa");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ta");

        Thread tb = new Thread(() -> {
            try {
                las.printStr("bb");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "tb");

        Thread tc = new Thread(() -> {
            try {
                las.printStr("cc");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "tc");

        ta.start();
        tb.start();
        tc.start();
    }

}