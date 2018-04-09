package com.seyha.thread.waitnotify;

/**
 * Created by hiemseyha on 4/9/18.
 */
public class ProducerConsumer {

    private static  int[] buffer;
    private static int count;

    static class Producer {
        void produce() {
            while (isFull(buffer)) {

            }

            buffer[++count] = 1;
        }
    }


    static  class Consumer {
        void consumer() {
            while(isEmpty(buffer)) {

            }

            buffer[--count] = 0;
        }
    }

    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    static boolean isFull(int[] buffer) {
        return buffer.length == count;
    }

    public static  void main(String[] args) throws InterruptedException {

        buffer = new int[10];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();



        Runnable produceTask = () -> {
          for(int i = 0; i < 50; i++)  {
              producer.produce();
          }
          System.out.println("Done producing!");
        };


        Runnable consumerTask = () -> {
          for(int i = 0;i < 50; i++) {
              consumer.consumer();
          }
            System.out.println("Done consumer!");
        };


        Thread produceThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumerTask);

        produceThread.start();
        consumerThread.start();

        produceThread.join();
        consumerThread.join();


        System.out.println("Data in buffer is " + count);
    }
}
