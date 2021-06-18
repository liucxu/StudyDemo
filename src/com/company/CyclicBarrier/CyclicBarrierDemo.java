package com.company.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            System.out.println("公共屏障点达到");
        }
    });

    public static void main(String[] args){
        for (int index=0;index<5;index++){
            new myThread().start();
        }
    }

    static class myThread extends Thread{
        @Override
        public void run() {
            System.out.println("线程: "+Thread.currentThread().getName()+" 执行并进入阻塞阻塞");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程: "+Thread.currentThread().getName()+"执行完毕");
        }
    }
}
