package com.zy.snippets.visitor;


import java.util.Iterator;

public abstract class Entry implements Element {

    abstract String getName();

    abstract int getSize();

    public void add(Entry entry) {
        throw new FileTreatmentException();
    }

    public Iterator iterator() {
        throw new FileTreatmentException();
    }

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
