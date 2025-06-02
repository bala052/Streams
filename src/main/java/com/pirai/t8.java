package com.pirai;

public class t8
{
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
for(int i=1;i<=10;i++){
    try {
        Thread.sleep(1000);
        System.out.println(i);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
            }
        });
        t.setDaemon(true);
        t.start();
        Thread.sleep(6000);
        System.out.println("main thread finished");
    }
}
