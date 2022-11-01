package cn.nolaurence.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: nolaurence
 * @Description: LockPractice
 * @Date: 2022/10/15
 */
public class LockPractice {
    /**
     * ReentrantLock
     */
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        // @FunctionalInterface 函数式接口
        new Thread(() -> {
            for (int i = 1; i < 30; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i < 30; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i < 30; i++) {
                ticket.sale();
            }
        }, "C").start();

    }
}

class Ticket {

    private int number = 30;

    /**
     * 默认为非公平锁，可插队
     */
    ReentrantLock lock = new ReentrantLock();

    /**
     * Synchronized 无法判断锁的状态
     * synchronized 会自动释放锁，lock必须要手动释放
     * lock有非公平锁，线程不会一直等待
     * Synchronized 是可重入锁，非公平；lock的锁类型可设置
     * Synchronized适合小代码块，lock适合更大量的同步代码
     */

//    public void sale() {
//        if (number > 0) {
//            System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余:"+number);
//        }
//    }
    public void sale() {
        lock.lock();  // 加锁

        try {
            // code goes here
            if (number > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余:"+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  // 解锁
        }
    }
}
