package com.company.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args){
        for (int index=0;index<3;index++){
            lock.lock();
        }
        for (int index=0;index<3;index++){
            lock.unlock();
        }

        for(int index=0;index<5;index++){
            new Thread(new ThreadDemo(index)).start();
        }
    }
    static class ThreadDemo implements Runnable{

        int id;
        public ThreadDemo(int id){
            this.id=id;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int index=0;index<2;index++){
                lock.lock();
                System.out.println("获取锁的线程是：Thread "+id);
                lock.unlock();
            }
        }
    }
}
