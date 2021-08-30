package ua.GoIT.modul12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintH2O {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        H2O h2o = new H2O();

        for (int i = 0; i < 2; i++) {
            threadPool.execute(() -> h2o.releaseHydrogen(() -> System.out.print("H")));
            threadPool.execute(() -> h2o.releaseHydrogen(() -> System.out.print("H")));
            threadPool.execute(() -> h2o.releaseOxygen(() -> System.out.print("O")));
        }

        threadPool.shutdown();
    }
}
