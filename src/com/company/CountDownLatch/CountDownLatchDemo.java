package com.company.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static CountDownLatch countDownLatch=new CountDownLatch(5);

    public static void main(String[] args){
        System.out.println("主线程开始启动");
        for(int index=0;index<5;index++){
            new myThread(countDownLatch).start();
        }
        System.out.println("主线程进入阻塞");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程继续执行结束");
    }

    static class myThread extends Thread{

        private CountDownLatch coutDown;

        public myThread(CountDownLatch countDownLatch){
            this.coutDown=countDownLatch;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("线程："+Thread.currentThread().getName()+"执行结束");
                coutDown.countDown();
            }
        }
    }
}
