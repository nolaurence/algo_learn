package cn.nolaurence.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: nolaurence
 * @Description: SomeImportant
 * @Date: 2022/10/31
 */
public class SomeImportant {
    /**
     * CountDownLatch
     * CyclicBarrier
     * Semaphore
     *
     * Executors
     * ForkJoinPool
     */

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("success");
        });

        for (int i = 1; i <= 7; i++) {

            final int temp = i;

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "collected " + temp + " barrier");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
