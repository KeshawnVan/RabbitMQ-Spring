package com.star.amqp;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ExecutorService executorPool = Executors.newFixedThreadPool(integers.size());


        for (Integer integer : integers) {
            executorPool.submit(() -> {
                System.out.println("sleep " + integer + "s start");
                try {
                    Thread.sleep(integer * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sleep " + integer + "s end");
            });
        }


        executorPool.shutdown();
        try {
            executorPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sss");
    }
}
