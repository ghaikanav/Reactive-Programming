package com.reactive.webfluxdemo.util;

public class SleepUtil {
    public static void sleepForSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
