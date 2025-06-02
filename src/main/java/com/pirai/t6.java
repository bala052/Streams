package com.pirai;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class t6
{
    public static void main(String[] args) {
        ExecutorService es= Executors.newFixedThreadPool(4);
        for(int i=0;i<=5;i++){
            int task=i;
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        System.out.println("task"+task+"completed");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
            es.shutdown();
            try {
                if(!es.awaitTermination(5, TimeUnit.SECONDS)){
                    es.shutdownNow();
                    System.out.println("hello");
                }
            }
            catch (Exception ie){
               ie.printStackTrace();
            }

    }
}
