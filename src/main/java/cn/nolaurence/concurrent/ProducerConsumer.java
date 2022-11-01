package cn.nolaurence.concurrent;

/**
 * @Author: nolaurence
 * @Description: ProducerConsummer
 * @Date: 2022/10/16
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Date date = new Date();

        /**
         * 生产消费者问题
         * 单例模式
         * 排序算法
         * 死锁
         */
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    date.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    date.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}

class Date {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        /**
         * 多线程状况下使用if会产生虚假唤醒问题，应当使用while
         * java doc：
         * 线程也可以唤醒而不被通知，中断or超时，即所谓的虚假唤醒。虽然这在实践中很少会发生，
         * 但应用程序必须通过测试。应当使线程被唤醒的条件来方案，并且如果条件不满足时则继续等待
         * 即，等待应该总是出现在循环中
         * example：
         * synchronized (obj) {
         *     while(<condition does not hold>)
         *         obj.wait(timeout);
         *     ... // Perform action appropriate to condition
         */
        if (number != 0) {
            // wait
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);

        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        if (number == 0) {
            // wait
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);

        this.notifyAll();
    }
}
