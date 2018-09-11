package vivo;

import java.util.concurrent.LinkedBlockingDeque;

public class ProducerAndConsumer{
    private static final int CAPACITY = 10;

    public static void main(String args[]){
        LinkedBlockingDeque<Integer> blockingQueue = new LinkedBlockingDeque<>(CAPACITY);

        Thread producer1 = new Producer("P1", blockingQueue, CAPACITY);
        Thread producer2 = new Producer("P2", blockingQueue, CAPACITY);
        Thread consumer1 = new Consumer("C1", blockingQueue, CAPACITY);
        Thread consumer2 = new Consumer("C2", blockingQueue, CAPACITY);
        Thread consumer3 = new Consumer("C3", blockingQueue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

    /**
     * 生产者
     */
    public static class Producer extends Thread{
        private LinkedBlockingDeque<Integer> blockingQueue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name, LinkedBlockingDeque<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.blockingQueue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                try {
                    blockingQueue.put(i);
                    System.out.println("[" + name + "] Producing value : +" + i);
                    i++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 消费者
     */
    public static class Consumer extends Thread{
        private LinkedBlockingDeque<Integer> blockingQueue;
        String name;
        int maxSize;

        public Consumer(String name, LinkedBlockingDeque<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.blockingQueue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                try {
                    int x = blockingQueue.take();
                    System.out.println("[" + name + "] Consuming : " + x);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}