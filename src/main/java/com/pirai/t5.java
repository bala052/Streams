package com.pirai;

import java.util.LinkedList;
import java.util.Queue;

public class t5
{
    int capacity=5;
    private final Queue<Integer> buffer=new LinkedList<>();
    private final Object lock = new Object();

     class produce extends Thread{
        @Override
        public void run() {
            int value=0;
            while (true){
                synchronized (lock){
                    if(buffer.size()==capacity){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    buffer.add(value);
                    System.out.println(value);
                    value++;
                    lock.notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
     class consume extends Thread{
        @Override
        public void run() {
while (true){
    synchronized (lock){
        if(buffer.isEmpty()){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
int consumed=buffer.poll();
        System.out.println(consumed);
        lock.notify();
    }
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
        }
    }
    public static void main(String[] args) {
t5 t=new t5();
produce p =t.new produce();
consume c=t.new consume();
p.start();
c.start();
    }
}
