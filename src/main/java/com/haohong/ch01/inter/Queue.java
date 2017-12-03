package com.haohong.ch01.inter;

public interface Queue<Item> extends Iterable<Item> {
    public void enqueue(Item item);
    public Item dequeue();
    public boolean isEmpty();
    public int size();
}
