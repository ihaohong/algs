package com.haohong.collection.list;

public class ArrayList<T> implements List<T> {
    private Object[] objs;
    private int size = 0; // 已使用容量
    private int cap = 0; // 当前总容量

    public ArrayList() {
        this(10);
    }

    public ArrayList(int cap) {
        this.cap = cap;
        objs = (T[]) new Object[cap];
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
    public boolean add(int index, T e) {
        ensureSize(size + 1);
        for (int i = size - 1; i >= index; i--) {
            objs[i + 1] = objs[i];
        }
        objs[index] = e;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T e) {
        for (int i=0; i<size; i++) {
            if (e.equals(get(i))) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(T e) {
        return indexOf(e) != -1;
    }

    @Override
    public boolean delete(int index) {
        for (int i = index; i < size - 1; i++) {
            objs[i] = objs[i+1];
        }
        size--;
        objs[size] = null;
        return true;
    }

    @Override
    public boolean remove(T o) {
        return delete(indexOf(o));
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
