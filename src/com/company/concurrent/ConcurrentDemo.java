package com.company.concurrent;

public class ConcurrentDemo {
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                for(int index=0;index<5;index++){
                    System.out.println("Current Thread: "+Thread.currentThread().getName()+" loop index="+index);
                }
            }
        }
    }
    public static void main(String[] args){
        MyRunnable myRunnable=new MyRunnable();
        Thread thread1=new Thread(myRunnable);
        Thread thread2=new Thread(myRunnable);
        thread1.start();
        thread2.start();
    }
}
