package ua.GoIT.modul12;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {
    private final Semaphore hydrogen = new Semaphore(2);
    private final Semaphore oxygen = new Semaphore(1);

    private final CyclicBarrier cb = new CyclicBarrier(3, () -> {
        hydrogen.release(2);
        oxygen.release(1);
    });

    public void releaseHydrogen(Runnable releaseHydrogen) {
        try {
            hydrogen.acquire();

            releaseHydrogen.run();

            cb.await();
            hydrogen.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void releaseOxygen(Runnable releaseOxygen) {
        try {
            oxygen.acquire();

            releaseOxygen.run();

            cb.await();
            oxygen.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
