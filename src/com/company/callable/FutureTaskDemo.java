package com.company.callable;

import java.util.concurrent.*;

public class FutureTaskDemo {

    public static void main(String[] args){
        ExecutorService threadPool=Executors.newCachedThreadPool();
        Task task=new Task();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(task);
        //threadPool.submit(futureTask);
        new Thread(futureTask).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程正在执行任务");
        try {
            System.out.println("子线程返回结果是: "+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在计算");
            Thread.sleep(3000);
            int index=0;
            int sum=0;
            while(index<100){
                sum=sum+index;
                index++;
            }
            return sum;
        }
    }
}
