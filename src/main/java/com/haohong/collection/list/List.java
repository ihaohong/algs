package com.haohong.collection.list;

public interface List<T> {
    boolean add(T e);
    boolean add(int index, T e);
    int size();
    T get(int i);
}
