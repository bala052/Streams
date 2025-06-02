package com.pirai;

public class t2
{
    static class printnum implements Runnable{
        @Override
        public void run() {
            for (int i=1;i<=10;i++){
                try {
                    Thread.sleep(500);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        printnum pn=new printnum();
        Thread t=new Thread(pn);
        t.start();
    }
}
