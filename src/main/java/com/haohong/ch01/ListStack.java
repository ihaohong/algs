package com.haohong.ch01;

import com.haohong.ch01.inter.Stack;

import java.util.Iterator;

/**
 * Created by haohong on 02/12/2017.
 */
public class ListStack<Item> implements Stack<Item>, Iterator<Item> {
    private Node first;

    private int N = 0;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;

        N--;

        return item;
    }

    public boolean hasNext() {
        return false;
    }

    public Item next() {
        return null;
    }

    public void remove() {

    }
}
