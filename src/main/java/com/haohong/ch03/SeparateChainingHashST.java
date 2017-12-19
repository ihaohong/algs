package com.haohong.ch03;

import com.haohong.ch01.ListQueue;
import com.haohong.ch01.inter.Queue;
import com.haohong.ch03.inter.ST;

public class SeparateChainingHashST<Key, Value> implements ST<Key, Value> {
    private int N = 0; // 键值对总数
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
        N++;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);

        N--;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    public int size() {
        return N;
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new ListQueue<Key>();

        for (int i = 0; i < M; i++) { // 遍历每个拉链
            Iterable<Key> keys = st[i].keys();
            for (Key key : keys) {
                queue.enqueue(key);
            }
        }

        return queue;
    }
}
