package com.haohong.collection.list;

import java.util.Iterator;

public interface List<T> {
    boolean add(T e);
    boolean add(int index, T e);
    int size();
    T get(int i);
    int indexOf(T e);
    boolean contains(T e);
    boolean remove(T o);
    boolean delete(int index);
    Iterator<T> iterator();
}
