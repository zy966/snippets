package com.zy.snippets.object;

import org.junit.Test;

import java.util.Objects;

/**
 * @author : zy
 * @date : 2019/4/8 0:46
 */
public class ObjectsTest {

    @Test
    public void t1() {
        Objects.equals("", "");
        Objects.deepEquals("", "");
    }
}
