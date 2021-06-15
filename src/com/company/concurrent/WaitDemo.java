package com.company.concurrent;

public class WaitDemo {
    static class notifyThread extends Thread{
        @Override
        public void run() {
            synchronized (this){
                System.out.println("Current Thread "+Thread.currentThread().getName()+" notify");
            }
        }
    }
    public static void main(String[] args){
        notifyThread notifyThread=new notifyThread();
        synchronized (notifyThread){
            notifyThread.start();
            System.out.println("Current Thread "+Thread.currentThread().getName()+" wait()");
            try {
                notifyThread.wait();
                System.out.println("Current Thread "+Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
