package com.demo.web.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {


    private static LRUCache<String, Integer> cache = new LRUCache<>(10);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            cache.put("key" + i, i);
        }
        System.out.println("all cache :" + cache);
        cache.get("key3");
        System.out.println("get key3 :"+ cache);
        cache.get("key4");
        System.out.println("get key4: "+ cache);
        cache.get("key4");
        System.out.println("get key4 :"+ cache);
        cache.put("key" + 10, 10);
        System.out.println("cache :"+ cache);
        cache.put("key" + 11, 11);
        System.out.println("cache :"+ cache);
        cache.put("key" + 12, 12);
        System.out.println("cache :"+ cache);

        /*ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new MyThread());*/

//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        fixedThreadPool.execute(new MyThread());
//        fixedThreadPool.execute(new MyThread());
//        fixedThreadPool.execute(new MyThread());
    }




}



