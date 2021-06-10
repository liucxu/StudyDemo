package com.company.ThredaPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * 一般需要根据任务的类型来配置线程池大小：
 *
 * 如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 NCPU+1
 *
 * 如果是IO密集型任务，参考值可以设置为2*NCPU
 */
public class ThreadPoolDemo {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,10,200, MINUTES,new ArrayBlockingQueue<Runnable>(5));
        for(int index=0;index<15;index++){
            Task task=new Task(index);
            threadPoolExecutor.execute(task);
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行玩别的任务数目："+threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
    static class Task implements Runnable{
        private int num;
        public Task(int num){
            this.num=num;
        }
        @Override
        public void run() {
            System.out.println("正在执行Task "+num);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行完毕:"+num);
        }
    }
}
