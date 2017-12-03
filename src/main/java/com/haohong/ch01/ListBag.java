package com.haohong.ch01;

import com.haohong.ch01.inter.Bag;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ListBag<Item> implements Bag<Item> {
    private Node first;
    private Node last;

    private int N = 0;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;

        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }

        N++;
    };

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
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
}
