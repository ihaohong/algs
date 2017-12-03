package com.haohong.ch01.inter;

public interface Bag<Item> extends Iterable<Item> {
    public void add(Item item);
    public int size();
    public boolean isEmpty();
}
