package com.haohong.collection.list;

import java.util.Iterator;

public class LinkedList <T> implements List<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    @Override
    public boolean add(T e) {
        Node oldLst = last;
        last = new Node<T>();
        last.item = e;
        if (isEmpty()) {
            first = last;
        } else {
            oldLst.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T e) {
        Node<T> newNode = new Node<>();
        newNode.item = e;
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<T> prev = node(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        return node(index).item;
    }

    @Override
    public int indexOf(T e) {
        int index = 0;
        for (Node<T> t = first; t != null; t = t.next) {
            if (e == null) {
                if (e == t.item) {
                    return index;
                }
            } else {
                if (e.equals(t.item)) {
                    return index;
                }
            }

            index++;
        }

        return -1;
    }

    @Override
    public boolean contains(T e) {
        return indexOf(e) != -1;
    }

    @Override
    public boolean delete(int index) {
        checkIndex(index);

        if (index == 0) {
            first = first.next;
        } else {
            Node<T> prev = node(index - 1);
            prev.next = prev.next.next;
        }

        size--;
        return true;
    }

    @Override
    public boolean remove(T o) {
        return delete(indexOf(o));
    }

    private Node<T> node(int index) {
        checkIndex(index);
        Node<T> current = first;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private void checkIndex(int index) {
        if (index > size-1) throw new IndexOutOfBoundsException(index);
    }

    private class Itr implements Iterator<T> {
        Node<T> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.item;
            current = current.next;
            return data;
        }
    }

    private class Node<T> {
        T item;
        Node<T> next;
    }
}
