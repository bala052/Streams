package com.pirai;

public class t3
{
    static class counter{
        int count=0;
        public synchronized void countt(){
            count++;
        }

        public int getCount() {
            return count;
        }
    }
    static class incrementcounter extends Thread{
        private counter counnt;

        public incrementcounter(counter counnt) {
            this.counnt = counnt;
        }

        @Override
        public void run() {
          for(int i=1;i<=5;i++){
              try {
                  Thread.sleep(500);
                  counnt.countt();
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              } System.out.println(i);
          }
        }
    }
    public static void main(String[] args) throws InterruptedException {
counter t=new counter();
incrementcounter i=new incrementcounter(t);
incrementcounter i1=new incrementcounter(t);
i.start();
i1.start();
i.join();
i1.join();
        System.out.println("final : "+t.getCount() );
    }
}
