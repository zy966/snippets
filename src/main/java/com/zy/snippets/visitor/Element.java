package com.zy.snippets.visitor;

public interface Element {

    void accept(Visitor visitor);

}
