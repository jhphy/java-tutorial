package com.concurrency;

public class Ticket implements Runnable {
     private int num = 100;
     public void run() {
         while(true) {
             synchronized (this) {
                 if (num > 0) {
                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName() + "...sale..." + num--);
                 }
             }
         }
     }
}

class TicketDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t2 = new Thread(t);
        Thread t1 = new Thread(t);
        t1.start();
        t2.start();
    }
}
