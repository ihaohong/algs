package com.haohong.ch03;

import com.haohong.ch03.inter.ST;

public class SeparateChainingHashST<Key, Value> implements ST<Key, Value> {
    private int N; // 键值对总数
    private int M; // 散列表的大小
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;

        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];

        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void delete(Key key) {

    }
    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return false;
    }
    public int size() {
        return 0;
    }
    public Iterable<Key> keys() {
        return null;
    }
}
