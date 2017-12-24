package com.haohong.ch01;

import com.haohong.ch01.inter.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by haohong on 02/12/2017.
 */
public class ListStack<Item> implements Stack<Item> {
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

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Item item : this) {
            sb.append(item.toString() + " ");
        }

        return sb.toString();
    }
}
