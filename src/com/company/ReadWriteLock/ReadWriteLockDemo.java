package com.company.ReadWriteLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock=lock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock=lock.writeLock();
    public void read(){
        readLock.lock();
        try {
            System.out.println("线程： "+Thread.currentThread().getName()+"读操作");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
    public void write(){
        writeLock.lock();
        try {
            System.out.println("线程： "+Thread.currentThread().getName()+"写操作");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args){
        ReadWriteLockDemo demo=new ReadWriteLockDemo();
        new Thread(()->demo.write()).start();
        new Thread(()->demo.read()).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                demo.write();
//                demo.read();
//            }
//        }).start();
    }
}
