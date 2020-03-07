package com.haohong.collection.list;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private Object[] objs;
    private int size = 0; // 已使用容量
    private int cap = 10; // 当前总容量

    public ArrayList() {
        objs = new Object[cap];
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
        cap *= 2;
        objs = Arrays.copyOf(objs, cap);
    }
}
