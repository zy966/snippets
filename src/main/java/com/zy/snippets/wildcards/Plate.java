package com.zy.snippets.wildcards;

/**
 * @Author: zy
 * @Date: 2018/12/23 14:55
 */
public class Plate<T> {

    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}
