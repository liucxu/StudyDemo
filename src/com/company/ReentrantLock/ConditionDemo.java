package com.company.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private static ReentrantLock lock;
    private static Condition condition;
    public static void main(String[] args){
        lock=new ReentrantLock();
        condition= lock.newCondition();
        lock.lock();
        new Thread(new MyRunnable()).start();
        try {
            System.out.println("主线程等待阻塞，等待通知");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("主线程完成工作");
    }

    static  class MyRunnable implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try {
                condition.signal();
                System.out.println("子线程获得锁，完成工作，释放锁，通知主线程");
            }
            finally {
                lock.unlock();
            }
        }
    }
}
