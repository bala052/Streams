package com.pirai;

public class t7
{
    private  static final Object lock=new Object();
    private static final Object lock1=new Object();
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            synchronized (lock){
                System.out.println("lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("waiting for lock1");
                synchronized (lock1){
                    System.out.println("lock1");
                }
            }
        });
        Thread t2=new Thread(()->{
           synchronized (lock1){
               System.out.println("lock1");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("waiting for lock");
              synchronized (lock){
                  System.out.println("lock");
              }
           }
        });
        t.start();
        t2.start();
    }
}
