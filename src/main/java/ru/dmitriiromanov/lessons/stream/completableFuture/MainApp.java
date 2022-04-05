package ru.dmitriiromanov.lessons.stream.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class MainApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "Hi", Executors.newCachedThreadPool());

        System.out.println(future.thenApply(result -> {
            System.out.println(result + " all"); //output Hi all
            return result;
        }).get());                               //output Hi

        future.thenApplyAsync(result -> {
            System.out.println(result + ", world!"); //output Hi, world!
            return result;
        });

        Thread.sleep(500);
       // future.get();
    }
}
