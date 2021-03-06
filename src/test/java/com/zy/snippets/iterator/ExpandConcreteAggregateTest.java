package com.zy.snippets.iterator;

import org.junit.Test;

public class ExpandConcreteAggregateTest {

    @Test
    public void next1() {
        ExpandConcreteAggregate aggregate = new ExpandConcreteAggregate();
        aggregate.append("a");
        aggregate.append("b");
        aggregate.append("c");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        } }

}
