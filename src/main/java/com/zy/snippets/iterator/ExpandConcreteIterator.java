package com.zy.snippets.iterator;

public class ExpandConcreteIterator implements Iterator<String> {

    private int index;

    private ExpandConcreteAggregate aggregate;

    public ExpandConcreteIterator(ExpandConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.getLength();
    }

    @Override
    public String next() {
        return aggregate.getIndex(index++);
    }

}
