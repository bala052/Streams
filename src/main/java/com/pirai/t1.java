package com.pirai;

public class t1
{
    static class print extends Thread{
        @Override
        public void run() {
            for(int i=1;i<=5;i++){
                try {
                    Thread.sleep(1000);
                    System.out.println("hello from gulugulu ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }}
    }
    public static void main(String[] args) {
        print p=new print();
        p.start();
    }
}
