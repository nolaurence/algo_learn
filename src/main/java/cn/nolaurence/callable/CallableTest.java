package cn.nolaurence.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: nolaurence
 * @Description: CallableTest
 * @Date: 2022/10/30
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start(); // 怎么启动callable

        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);  // 适配类

        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();

        Integer o = (Integer) futureTask.get();  // 这个get方法可能会产生阻塞！所以放在最后
        // 或者使用异步通信来处理
        System.out.println(o);
    }
}


class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}
