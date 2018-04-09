package com.seyha.thread.firstrunnable;

/**
 * Created by hiemseyha on 4/9/18.
 */


public class FirstRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("I am running " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);

        thread.setName("My Thread");

        thread.start();

//        thread.run();
    }
}
