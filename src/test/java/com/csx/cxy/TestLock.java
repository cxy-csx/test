package com.csx.cxy;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
public class TestLock {

    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    @Test
    void test() {




    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: 持有 resource1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 1: 等待 resource2");
                synchronized (resource2) {
                    System.out.println("Thread 1: 同时持有 resource1 和 resource2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: 持有 resource2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 2: 等待 resource1");
                synchronized (resource1) {
                    System.out.println("Thread 2: 同时持有 resource1 和 resource2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
