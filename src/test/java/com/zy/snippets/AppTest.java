package com.zy.snippets;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test () {
        List<Object> list = new ArrayList<>();
        List<String> slist = new ArrayList<>();

        list.add(new Object());
        list.add(new String());

        list.addAll(slist);

        add(slist);
    }

    private void add(List<? extends Object> list) {
        list = new ArrayList<String>();
        list.add(null);
        Object o = list.get(1);
    }

    public void testPOJO() {
        Person person = new Person();
        Male m = new Male();
    }

    public void test1() {
        Map map = new HashMap<>();
    }

}
