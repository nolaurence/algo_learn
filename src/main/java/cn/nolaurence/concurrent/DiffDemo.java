package cn.nolaurence.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: nolaurence
 * @Description: DiffDemo
 * @Date: 2022/10/22
 */
public class DiffDemo {

    private int number = 0;



    public static void main(String[] args) {
    }
}

class Data2 {

    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // 等待 condition.await()
    // 唤醒全部 condition.signalAll();

    // condition 可以精准通知线程

    public void increment() throws InterruptedException {

        lock.lock();

        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();

        try {
            while (number == 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
