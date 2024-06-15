package io.github.devandref.pucminastrabalho.pucminastrabalho.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;
import java.util.stream.Stream;

@RestController
public class StreamingController {

    @GetMapping(value = "/api/Fib/streaming")
    public Stream<Long> streamFibonacci() {
        Supplier<Long> fibonacciSupplier = new Supplier<Long>() {
            long previous = 0;
            long current = 1;

            @Override
            public Long get() {
                long next = previous + current;
                previous = current;
                current = next;
                return previous;
            }
        };

        return Stream.generate(fibonacciSupplier)
                .map(n -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return n;
                });
    }

    @GetMapping(value = "/api/Fib/{id}")
    public Stream<Long> fibByID(@PathVariable String id) {
        Supplier<Long> fibonacciSupplier = new Supplier<Long>() {
            long previous = 0;
            long current = 1;

            @Override
            public Long get() {
                long next = previous + current;
                previous = current;
                current = next;
                return previous;
            }
        };

        return Stream.generate(fibonacciSupplier)
                .map(n -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return n;
                }).limit(Integer.valueOf(id));
    }

    @GetMapping(value = "/api/Fib")
    public Stream<Long> fibLimit100() {
        Supplier<Long> fibonacciSupplier = new Supplier<Long>() {
            long previous = 0;
            long current = 1;

            @Override
            public Long get() {
                long next = previous + current;
                previous = current;
                current = next;
                return previous;
            }
        };

        return Stream.generate(fibonacciSupplier)
                .map(n -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return n;
                }).limit(100);
    }




}

