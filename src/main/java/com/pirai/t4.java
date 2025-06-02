package com.pirai;

public class t4
{
    static class inte extends Thread{
        @Override
        public void run() {
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(1000);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    System.out.println("interrupted.....");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        inte i=new inte();
        i.start();

        Thread.sleep(6000);
        i.interrupt();
        System.out.println("inte stopped");
    }
}
