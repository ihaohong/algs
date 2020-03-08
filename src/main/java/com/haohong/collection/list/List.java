package com.haohong.collection.list;

import java.util.Iterator;

public interface List<T> {
    boolean add(T e);
    boolean add(int index, T e);
    int size();
    T get(int i);
    int indexOf(T e);
    boolean contains(T e);
    boolean delete(int index);
    boolean remove(T e);
    Iterator<T> iterator();

// TODO
//    void lPush(T e);
//    T lPop();
//    void rPush(T e);
//    T rPop();
}
