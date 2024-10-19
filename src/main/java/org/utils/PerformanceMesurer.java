package org.utils;

public class PerformanceMesurer {
    public void mesure(Runnable runnable){
        long startTime = System.nanoTime();

        runnable.run();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Execution time: " + duration / 1_000_000 + " milliseconds");
    }
}
