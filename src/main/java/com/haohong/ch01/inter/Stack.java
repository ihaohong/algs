package com.haohong.ch01.inter;

import java.util.Iterator;

/**
 * Created by haohong on 02/12/2017.
 */
public interface Stack<Item> extends Iterable<Item> {
    public boolean isEmpty();
    public int size();
    public void push(Item item);
    public Item pop();
}
