package com.haohong.collection.list;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private Object[] objs;
    private int size = 0; // 已使用容量
    private int cap = 0; // 当前总容量

    public ArrayList() {
        this(10);
    }

    public ArrayList(int cap) {
        this.cap = cap;
        objs = new Object[cap];
    }

    @Override
    public T get(int i) {
        return (T) objs[i];
    }

    @Override
    public boolean add(T e) {
        ensureSize(size + 1);
        objs[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 扩容
     * @param ensureSize
     */
    protected void ensureSize(int ensureSize) {
        if (ensureSize <= cap) return;

        ArrayList<T> newList = new ArrayList<>(cap*2);
        for (int i=0; i<size; i++) {
            newList.add(get(i));
        }

        objs = newList.objs;
        size = newList.size;
        cap = newList.cap;
    }
}
