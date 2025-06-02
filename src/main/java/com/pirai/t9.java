package com.pirai;

import java.util.concurrent.*;

public class t9
{
    static class factorial implements Callable<Integer> {
        private int number;

        public factorial(int number) {
            this.number = number;
        }
        @Override
        public Integer call() throws Exception {
            int res=1;
            for (int i = 1; i <= number; i++) {
                res *= i;
            }
return res;
        }
    }
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService es=Executors.newSingleThreadExecutor();
            factorial task=new factorial(5);// Create a Callable task
            Future<Integer> future= es.submit(task); // Submit the task to the executor
            int fact= future.get();
            System.out.println(fact);
            es.shutdown();
        }
    }
