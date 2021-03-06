package com.zy.snippets.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: zy
 * @Date: 2018/12/22 11:00
 */
public class lambda {

    @Test
    public void collection() {
        List<String> list = new ArrayList<>();

        list.stream();

    }

    @Test
    public void stream() {
        Stream.of("one", "two", "three", "four")
                         .filter(e -> e.length() > 3)
                        .peek(e -> System.out.println("Filtered value: " + e))
                         .map(String::toUpperCase)
                         .peek(e -> System.out.println("Mapped value: " + e))
                         .collect(Collectors.toList());
    }

    @Test
    public void mapReduce() {
        List<String> strs = Arrays.asList("one", "two", "three", "four");
        int charNum = strs.stream()
                .filter(e -> e.startsWith("t"))
                .peek(e -> System.out.println(e))
                .map(e -> e.length())
                .peek(e -> System.out.println(e))
                .reduce((result, e) -> result + e).get();

        System.out.println(charNum);
    }

    @Test
    public void faltMap() {
        /**获取单词，并且去重**/
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
                "hello world welcome");

        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());

        System.out.println("---------- ");

        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================================================");

        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());

    }
}
