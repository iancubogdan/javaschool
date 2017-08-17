package com.db.javaschool.springdata.jdbc;

/**
 * Created by iancu on 8/13/2017.
 */
public class Remminder implements Runnable{

    private String message;
    private int seconds;

    public Remminder(String message, int seconds) {
        this.message = message;
        this.seconds = seconds;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(seconds *1000);
            System.out.println(message + " ");
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Remminder("1", 1));
        Thread t2 = new Thread(new Remminder("2", 2));
        Thread t3 = new Thread(new Remminder("3", 3));
        t3.start();
        t1.start();
        t3.join();
        t2.start();
        t1.join();
        t2.join();
    }
}
