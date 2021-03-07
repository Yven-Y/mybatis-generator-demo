package com.yven.worker.completionfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

/**
 * https://www.cnblogs.com/zhjh256/p/11829397.html
 *
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/25
 */
@Slf4j
public class CompletableFutureTest {


    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "custom-executor-" + count++);
        }
    });

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        // supplyAsync 无入参只有出参
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            System.out.println("投放和清洗制作米饭的材料");
            return "干净的没有新冠病毒的大米";
        }).thenAcceptAsync(result -> {
            // thenAcceptAsync 只有入参无出参，且放在另外线程执行
            System.out.println(result);
            System.out.println("通电，设定模式，开始煮米饭");
        }).thenRunAsync(() -> {
            // 传入Runnable，无返回（CompletableFuture<Void>）
            System.out.println("米饭做好了，可以吃了");
        });
        try {
            log.info("result: {}", future.get());

        } catch (Exception e) {

        }
    }

    private static void test2() {
        CompletableFuture rice = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始制作米饭，并获得煮熟的米饭");
            return "煮熟的米饭";
        });

        //煮米饭的同时呢，我又做了牛奶
        CompletableFuture<String> mike = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始热牛奶，并获得加热的牛奶");
            return "加热的牛奶";
        });

        // 我想两个都好了，才吃早饭，
        // thenCombineAsync有入参(两个CompletableFuture)，有返回值CompletableFuture<V>
        mike.thenCombineAsync(rice, (m, r) -> {
            System.out.println("早饭全都做好了：" + m + "," + r);
            return m + r;
        });
        // 有入参，无返回值 CompletableFuture<Void>
        mike.thenAcceptBothAsync(rice, (m, r) -> {
            System.out.println("早饭做好了：" + m + "," + r);
        });

        // 无入参和出参 CompletableFuture<Void>
        mike.runAfterBothAsync(rice, () -> {
            System.out.println("早饭做好了");
        });

        // 或者直接连接两个CompletableFuture
        // 将第一个stage结果作为参数给第二个stage，
        // ，返回值为`CompletableFuture<U>`，U为第二个Stage决定
        rice.thenComposeAsync(r -> CompletableFuture.supplyAsync(() -> {
            System.out.println("开始煮牛奶");
            System.out.println("同时开始煮米饭");
            return "mike";
        }));

    }
}
